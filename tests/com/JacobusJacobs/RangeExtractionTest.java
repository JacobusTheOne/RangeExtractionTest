package com.JacobusJacobs;
import org.junit.Assert;
import org.junit.Test;

public class RangeExtractionTest {
        @Test
        public void testEmptyString(){
            RangeExtraction rangeExtraction = new RangeExtraction();
            Assert.assertEquals("",rangeExtraction.summarizeCollection(rangeExtraction.collect("")));

        }
        @Test
        public void testTwoNumberedString(){
            RangeExtraction rangeExtraction = new RangeExtraction();
            Assert.assertEquals("1, 2",rangeExtraction.summarizeCollection(rangeExtraction.collect("1,2")));
        }
        @Test
        public void threeNumberedSequentialString(){
            RangeExtraction rangeExtraction = new RangeExtraction();
            Assert.assertEquals("1-3",rangeExtraction.summarizeCollection(rangeExtraction.collect("1,2,3")));
        }
        @Test
        public void negativeToPositiveNumbers(){
            RangeExtraction rangeExtraction = new RangeExtraction();
            Assert.assertEquals("-7, -6, -4, -2-1, 3, 6-8, 12-15, 21-24, 31",rangeExtraction.summarizeCollection(rangeExtraction.collect("-7,-6,-4,-2,-1,0,1,3,6,7,8,12,13,14,15,21,22,23,24,31")));
        }
}