package suites;

import Tests.*;
import lib.ui.MyListsPageObjects;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
       // ArticleTests.class,
       // ChangeAppConditionTests.class,
      //  GetStartedTest.class,
      //  MyListsTests.class,
      //  SearchTests.class
        RecommendedTests.class
}
)

public class TestSuite {}
