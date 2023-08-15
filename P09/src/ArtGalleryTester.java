////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: ArtGallery
// Course: CS 300 Spring 2022
//
// Author: Madhu Vuyyuru
// Email: mvuyyuru@wisc.edu
// Lecturer: Hobbes LeGault
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// pair programming was not used for this assignment
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// no outside source code was used
//
//
///////////////////////////////////////////////////////////////////////////////
// TODO Complete file header must be added here
import java.util.NoSuchElementException;
import java.util.ArrayList;

public class ArtGalleryTester {

  /**
   * Checks the correctness of the implementation of both compareTo() and equals() methods defined
   * in the Artwork class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testArtworkCompareToEquals() {
    // 1. test that CompareTo returns the right value when the artworks are equal
    Artwork testArtwork1 = new Artwork("Test", 1500, 20.0);
    Artwork compareArtwork1 = new Artwork("Test", 1500, 20.0);
    if (testArtwork1.compareTo(compareArtwork1) != 0) {
      return false;
    }

    // 2. test that CompareTo returns the right value when the testArtwork is older than the
    // compareArtwork
    Artwork testArtwork2 = new Artwork("OlderTest", 1400, 20.0);
    Artwork compareArtwork2 = new Artwork("Test", 1500, 20.0);
    if (testArtwork2.compareTo(compareArtwork2) != -1) {
      return false;
    }

    // 3. test that CompareTo returns the right value when the testArtwork is the same age but
    // cheaper than compareArtwork
    Artwork testArtwork3 = new Artwork("Test", 1500, 20.0);;
    Artwork compareArtwork3 = new Artwork("ExpensiveTest", 1500, 30.0);
    if (testArtwork3.compareTo(compareArtwork3) != -1) {
      return false;
    }

    // 4. test that CompareTo returns the right value when the testArtwork is the same age and price
    // as compareArtwork but lower lexicographically than compareArtwork
    Artwork testArtwork4 = new Artwork("LexicalTest", 1500, 20.0);
    Artwork compareArtwork4 = new Artwork("Test", 1500, 20.0);
    if (testArtwork4.compareTo(compareArtwork4) >= 0) {
      return false;
    }

    // 5. test that CompareTo returns the right value when the testArtwork is completely different
    // than compareArtwork
    Artwork testArtwork5 = new Artwork("DifferentTest", 1600, 40.0);
    Artwork compareArtwork5 = new Artwork("Test", 1500, 20.0);
    if (testArtwork5.compareTo(compareArtwork5) != 1) {
      return false;
    }

    // 6. test that equals returns the right value when the testArtwork is equal to compareArtwork
    Artwork testArtwork6 = new Artwork("Test", 1500, 20.0);
    Artwork compareArtwork6 = new Artwork("Test", 1500, 20.0);
    if (testArtwork6.equals(compareArtwork6) != true) {
      return false;
    }

    // 7. test that equals returns the right value when the testArtwork is not equal to
    // compareArtwork
    Artwork testArtwork7 = new Artwork("Test", 1500, 20.0);
    Artwork compareArtwork7 = new Artwork("UnequalTest", 1500, 20.0);
    if (testArtwork7.equals(compareArtwork7) != false) {
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks the correctness of the implementation of both addArtwork() and toString() methods
   * implemented in the ArtworkGallery class. This unit test considers at least the following
   * scenarios. (1) Create a new empty ArtworkGallery, and check that its size is 0, it is empty,
   * and that its string representation is an empty string "". (2) try adding one artwork and then
   * check that the addArtwork() method call returns true, the tree is not empty, its size is 1, and
   * the .toString() called on the tree returns the expected output. (3) Try adding another artwork
   * which is smaller that the artwork at the root, (4) Try adding a third artwork which is greater
   * than the one at the root, (5) Try adding at least two further artwork such that one must be
   * added at the left subtree, and the other at the right subtree. For all the above scenarios, and
   * more, double check each time that size() method returns the expected value, the add method call
   * returns true, and that the .toString() method returns the expected string representation of the
   * contents of the binary search tree in an increasing order from the smallest to the greatest
   * artwork with respect to year, cost, and then name. (6) Try adding a artwork already stored in
   * the tree. Make sure that the addArtwork() method call returned false, and that the size of the
   * tree did not change.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddArtworkToStringSize() {
    // 1. Create a new empty ArtworkGallery, and check that its size is 0, it is empty, and that its
    // string representation is an empty string "".
    ArtGallery testGallery1 = new ArtGallery();
    if (testGallery1.size() != 0 || !testGallery1.toString().equals("")) {
      return false;
    }
    // 2. try adding one artwork and then check that the addArtwork() method call returns true, the
    // tree is not empty, its size is 1, and the .toString() called on the tree returns the expected
    // output.
    Artwork testArtwork1 = new Artwork("Test", 1500, 20.0);
    if (!testGallery1.addArtwork(testArtwork1) || testGallery1.size() != 1
        || !testGallery1.toString().equals("[(Name: Test) (Year: 1500) (Cost: $20.0)]")) {
      return false;
    }

    // 3. Try adding another artwork which is smaller that the artwork at the root
    Artwork testArtwork2 = new Artwork("Test", 1400, 20.0);
    if (!testGallery1.addArtwork(testArtwork2) || testGallery1.size() != 2
        || !testGallery1.toString().equals("[(Name: Test) (Year: 1400) (Cost: $20.0)]" + "\n"
            + "[(Name: Test) (Year: 1500) (Cost: $20.0)]")) {
      return false;
    }

    // 4. Try adding a third artwork which is greater than the one at the root
    Artwork testArtwork3 = new Artwork("Test", 1600, 20.0);
    if (!testGallery1.addArtwork(testArtwork3)
        || testGallery1.size() != 3 && testGallery1.toString()
            .equals("[(Name: Test) (Year: 1400) (Cost: $20.0)]" + "\n"
                + "[(Name: Test) (Year: 1500) (Cost: $20.0)]" + "\n"
                + "[(Name: Test) (Year: 1600) (Cost: $20.0)]")) {
      return false;
    }

    // 5. Try adding at least two further artwork such that one must be added at the left subtree,
    // and the other at the right subtree.
    Artwork testArtwork4 = new Artwork("Test", 1450, 20.0);
    Artwork testArtwork5 = new Artwork("Test", 1550, 20.0);
    if (!testGallery1.addArtwork(testArtwork4) || !testGallery1.addArtwork(testArtwork5)
        || testGallery1.size() != 5 && testGallery1.toString()
            .equals("[(Name: Test) (Year: 1400) (Cost: $20.0)]" + "\n"
                + "[(Name: Test) (Year: 1450) (Cost: $20.0)]" + "\n"
                + "[(Name: Test) (Year: 1500) (Cost: $20.0)]" + "\n"
                + "[(Name: Test) (Year: 1550) (Cost: $20.0)]" + "\n"
                + "[(Name: YachtTest) (Year: 1600) (Cost: $20.0)]")) {
      return false;
    }
    // 6. Try adding a artwork already stored in the tree. Make sure that the addArtwork() method
    // call returned false, and that the size of the tree did not change.
    if (testGallery1.addArtwork(testArtwork4) || testGallery1.size() != 5 && testGallery1.toString()
        .equals("[(Name: Test) (Year: 1400) (Cost: $20.0)]" + "\n"
            + "[(Name: Test) (Year: 1450) (Cost: $20.0)]" + "\n"
            + "[(Name: Test) (Year: 1500) (Cost: $20.0)]" + "\n"
            + "[(Name: Test) (Year: 1550) (Cost: $20.0)]" + "\n"
            + "[(Name: YachtTest) (Year: 1600) (Cost: $20.0)]")) {
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * This method checks mainly for the correctness of the ArtworkGallery.lookup() method. It must
   * consider at least the following test scenarios. (1) Create a new ArtworkGallery. Then, check
   * that calling the lookup() method on an empty ArtworkGallery returns false. (2) Consider a
   * ArtworkGallery of height 3 which lookup at least 5 artwork. Then, try to call lookup() method
   * to search for the artwork having a match at the root of the tree. (3) Then, search for a
   * artwork at the right and left subtrees at different levels considering successful and
   * unsuccessful search operations. Make sure that the lookup() method returns the expected output
   * for every method call.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookup() {
    // 1. Create a new ArtworkGallery. Then, check that calling the lookup() method on an empty
    // ArtworkGallery returns false.
    ArtGallery testGallery1 = new ArtGallery();
    if (testGallery1.lookup("Test", 1500, 20.0)) {
      return false;
    }

    // 2.Consider a ArtworkGallery of height 3 which lookup at least 5 artwork. Then, try to call
    // lookup() method to search for the artwork having a match at the root of the tree.
    testGallery1.addArtwork(new Artwork("Test", 1500, 20.0));
    testGallery1.addArtwork(new Artwork("Test", 1400, 20.0));
    testGallery1.addArtwork(new Artwork("Test", 1600, 20.0));
    testGallery1.addArtwork(new Artwork("Test", 1450, 20.0));
    testGallery1.addArtwork(new Artwork("Test", 1550, 20.0));
    if (!testGallery1.lookup("Test", 1500, 20.0)) {
      return false;
    }
    // 3. Then, search for a artwork at the right and left subtrees at different levels considering
    // successful and unsuccessful search operations. Make sure that the lookup() method returns the
    // expected output for every method call.
    if (!testGallery1.lookup("Test", 1400, 20.0)) {
      return false;
    }
    if (!testGallery1.lookup("Test", 1600, 20.0)) {
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ArtworkGallery.height() method. This test must consider several
   * scenarios such as, (1) ensures that the height of an empty artwork tree is zero. (2) ensures
   * that the height of a tree which consists of only one node is 1. (3) ensures that the height of
   * a ArtworkGallery with the following structure for instance, is 4. (*) / \ (*) (*) \ / \ (*) (*)
   * (*) / (*)
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    // 1. ensures that the height of an empty artwork tree is zero.
    ArtGallery testGallery1 = new ArtGallery();
    if (testGallery1.height() != 0) {
      return false;
    }

    // 2. ensures that the height of a tree which consists of only one node is 1.
    testGallery1.addArtwork(new Artwork("Test", 1500, 20.0));
    if (testGallery1.height() != 1) {
      return false;
    }
    // 3. ensures that the height of a ArtworkGallery with 5 artwork is 3.
    testGallery1.addArtwork(new Artwork("Test", 1400, 20.0));
    testGallery1.addArtwork(new Artwork("Test", 1600, 20.0));
    testGallery1.addArtwork(new Artwork("Test", 1450, 20.0));
    testGallery1.addArtwork(new Artwork("Test", 1550, 20.0));
    if (testGallery1.height() != 3) {
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ArtworkGallery.getBestArtwork() method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetBestArtwork() {
    ArtGallery testGallery1 = new ArtGallery();
    if (testGallery1.getBestArtwork() != null)
      return false;
    Artwork testArtwork1 = new Artwork("Test", 1500, 20.0);
    Artwork testArtwork2 = new Artwork("Test", 1500, 25.0);
    Artwork testArtwork3 = new Artwork("Test", 1500, 27.0);
    Artwork testArtwork4 = new Artwork("Test", 1500, 30.0);

    testGallery1.addArtwork(testArtwork1);
    testGallery1.addArtwork(testArtwork2);
    testGallery1.addArtwork(testArtwork3);
    testGallery1.addArtwork(testArtwork4);
    if (testGallery1.getBestArtwork() != testArtwork4) {
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }


  /**
   * Checks for the correctness of ArtworkGallery.lookupAll() method. This test must consider at
   * least 3 test scenarios. (1) Ensures that the ArtworkGallery.lookupAll() method returns an empty
   * arraylist when called on an empty tree. (2) Ensures that the ArtworkGallery.lookupAll() method
   * returns an array list which contains all the artwork satisfying the search criteria of year and
   * cost, when called on a non empty artwork tree with one match, and two matches and more. Vary
   * your search criteria such that the lookupAll() method must check in left and right subtrees.
   * (3) Ensures that the ArtworkGallery.lookupAll() method returns an empty arraylist when called
   * on a non-empty artwork tree with no search results found.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookupAll() {
    ArrayList<Artwork> aList = new ArrayList<Artwork>();
    ArtGallery testGallery1 = new ArtGallery();
    // 1. Ensures that the ArtworkGallery.lookupAll() method returns an empty arraylist when called
    // on an empty tree.
    if (!testGallery1.lookupAll(2000, 1000).equals(aList)) {
      return false;
    }
    Artwork testArtwork1 = new Artwork("Test", 1500, 20.0);
    Artwork testArtwork2 = new Artwork("Test", 1600, 20.0);
    Artwork testArtwork3 = new Artwork("Test", 1400, 20.0);
    Artwork testArtwork4 = new Artwork("Test", 1450, 20.0);
    Artwork testArtwork5 = new Artwork("Test", 1550, 20.0);
    // 2. ensures that the ArtworkGallery.lookupAll() method returns an array list which contains
    // all the artwork satisfying the search criteria of year and cost, when called on a non empty
    // artwork tree with one match, and two matches and more.
    testGallery1.addArtwork(testArtwork2);
    aList.add(testArtwork2);
    if (!testGallery1.lookupAll(1600, 20.0).equals(aList)) {
      return false;
    }

    aList.clear();
    testGallery1.addArtwork(testArtwork1);
    testGallery1.addArtwork(testArtwork3);
    testGallery1.addArtwork(testArtwork4);
    testGallery1.addArtwork(testArtwork4);
    aList.add(testArtwork4);
    aList.add(testArtwork4);
    if (!testGallery1.lookupAll(1450, 20.0).equals(aList)) {
      System.out.println(aList);
      System.out.println(testGallery1.lookupAll(1450, 20.0));
      return false;
    }

    // 3. Ensures that the ArtworkGallery.lookupAll() method returns an empty arraylist when
    // called on a non-empty artwork tree with no search results found.
    aList.clear();
    aList.add(testArtwork5);
    if (testGallery1.lookupAll(1550, 20.0).equals(aList)) {
      return false;
    }
    return true; // Default return statement added to resolve compiler errors
  }

  /**
   * Checks for the correctness of ArtworkGallery.buyArtwork() method. This test must consider at
   * least 3 test scenarios. (1) Buying artwork that is at leaf node (2) Buying artwork at non-leaf
   * node (3) ensures that the ArtworkGallery.buyArtwork() method throws a NoSuchElementException
   * when called on an artwork that is not present in the BST
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testBuyArtwork() {
    ArtGallery testGallery1 = new ArtGallery();
    Artwork testArtwork1 = new Artwork("Test", 1500, 20.0);
    Artwork testArtwork2 = new Artwork("Test", 1600, 20.0);
    Artwork testArtwork3 = new Artwork("Test", 1400, 20.0);
    Artwork testArtwork4 = new Artwork("Test", 1450, 20.0);

    // 1. Buying artwork that is at leaf node
    testGallery1.addArtwork(testArtwork1);
    testGallery1.buyArtwork("Test", 1500, 20.0);
    if (testGallery1.size() != 0 || !testGallery1.isEmpty()
        || !testGallery1.toString().equals("")) {
      return false;
    }

    // 2. Buying artwork that is at non-leaf node
    testGallery1.addArtwork(testArtwork1);
    testGallery1.addArtwork(testArtwork2);
    testGallery1.addArtwork(testArtwork3);
    testGallery1.buyArtwork("Test", 1600, 20.0);
    if (testGallery1.size() != 2
        || !testGallery1.toString().equals("[(Name: Test) (Year: 1400) (Cost: $20.0)]\n"
            + "[(Name: Test) (Year: 1500) (Cost: $20.0)]")) {
      return false;
    }

    // 3. ensures that the ArtworkGallery.buyArtwork() method throws a NoSuchElementException when
    // called on an artwork that is not present in the BST
    try {
      testGallery1.addArtwork(testArtwork4);
      testGallery1.buyArtwork("DNE", 1500, 20.0);
      return false;
    } catch (NoSuchElementException nsee) {
    }
    return true; // Default return statement added to resolve compiler errors
  }


  /**
   * Returns false if any of the tester methods defined in this tester class fails.
   * 
   * @return false if any of the tester methods defined in this tester class fails, and true if all
   *         tests pass
   */
  public static boolean runAllTests() {
    if (testArtworkCompareToEquals() && testAddArtworkToStringSize() && testLookup() && testHeight()
        && testGetBestArtwork() && testLookupAll() && testBuyArtwork()) {
      return true;
    }
    return false; // Default return statement added to resolve compiler errors
  }

  /**
   * Calls the test methods
   * 
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("testArtworkCompareToEquals(): " + testArtworkCompareToEquals());
    System.out.println("testAddArtworkToStringSize(): " + testAddArtworkToStringSize());
    System.out.println("testLookup(): " + testLookup());
    System.out.println("testHeight(): " + testHeight());
    System.out.println("testGetBestArtwork(): " + testGetBestArtwork());
    System.out.println("testLookupAll(): " + testLookupAll());
    System.out.println("testBuyArtwork(): " + testBuyArtwork());
    System.out.println("runAllTests(): " + runAllTests());

  }

}


