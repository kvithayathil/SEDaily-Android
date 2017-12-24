package com.koalatea.thehollidayinn.softwareengineeringdaily.data.remote;

import com.koalatea.thehollidayinn.softwareengineeringdaily.test.BaseUnitTest;
import com.koalatea.thehollidayinn.softwareengineeringdaily.test.mock.TestTextUtils;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kurian on 24-Dec-17.
 */
public class EpisodeCategoryRepoTest extends BaseUnitTest {

  private EpisodeCategoryRepo repo;

  private final Map<Integer, String> testCategoryMap = new HashMap<>();

  @Override
  public void setUp() {
    super.setUp();
    setUpCategoryMap();
    repo = new EpisodeCategoryRepo(testCategoryMap, new TestTextUtils());
  }


  @Test
  public void getCategoryNameFromId_retrieves_expected_category_from_id() throws Exception {
    assertEquals("testCat1", repo.getCategoryNameFromId(0));
  }

  @Test
  public void getCategoryNameFromId_returns_null_value_with_error_id() throws Exception {
    assertNull(repo.getCategoryNameFromId(3));
  }

  @Test
  public void getCategoryIdFromName_returns_expected_id_from_name() throws Exception {
    assertEquals(0, repo.getCategoryIdFromName("testCat1"));
  }

  @Test
  public void getCategoryIdFromName_returns_expected_value_from_name_not_present() throws Exception {
    assertEquals(-1, repo.getCategoryIdFromName("testCat99"));
  }

  @Test
  public void getCategoryIdFromName_returns_expected_value_when_map_empty() throws Exception {
    testCategoryMap.clear();
    assertEquals(-1, repo.getCategoryIdFromName("testCat1"));
  }

  private void setUpCategoryMap() {
    testCategoryMap.put(0, "testCat1");
    testCategoryMap.put(1, "testCat2");
    testCategoryMap.put(2, "testCat3");
  }



}