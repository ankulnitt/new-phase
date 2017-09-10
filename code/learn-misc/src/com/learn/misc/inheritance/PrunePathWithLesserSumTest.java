package com.learn.misc.inheritance;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

public class PrunePathWithLesserSumTest {

	@Test
	public void test1() {
		PrunePathWithLesserSum ppwls1 = new PrunePathWithLesserSum(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
		ppwls1.prune(10);
		PrunePathWithLesserSum ppwlsExpected1 = new PrunePathWithLesserSum(Arrays.asList(1, null, 3, null, null, 6, 7));
		assertEquals(ppwlsExpected1, ppwls1);
	}

	@Test
	public void test2() {
		PrunePathWithLesserSum ppwls2 = new PrunePathWithLesserSum(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
		ppwls2.prune(100);
		PrunePathWithLesserSum ppwlsExpected2 = new PrunePathWithLesserSum(Collections.emptyList());
		assertEquals(ppwlsExpected2, ppwls2);
	}

	@Test
	public void test3() {
		PrunePathWithLesserSum ppwls3 = new PrunePathWithLesserSum(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
		ppwls3.prune(0);
		PrunePathWithLesserSum ppwlsExpected3 = new PrunePathWithLesserSum(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
		assertEquals(ppwlsExpected3, ppwls3);
	}

}
