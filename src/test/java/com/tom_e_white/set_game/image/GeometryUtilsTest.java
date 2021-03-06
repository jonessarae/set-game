package com.tom_e_white.set_game.image;

import georegression.struct.shapes.Quadrilateral_F64;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GeometryUtilsTest {
    @Test
    public void testSortRowWise() {
        Quadrilateral_F64 q00 = new Quadrilateral_F64(0, 1, 10, 1, 10, 11, 0, 11);
        Quadrilateral_F64 q01 = new Quadrilateral_F64(20, 0, 30, 0, 30, 10, 20, 10);
        Quadrilateral_F64 q02 = new Quadrilateral_F64(40, 2, 50, 2, 50, 12, 50, 12);

        Quadrilateral_F64 q10 = new Quadrilateral_F64(0, 101, 10, 101, 10, 111, 0, 111);
        Quadrilateral_F64 q11 = new Quadrilateral_F64(20, 100, 30, 100, 30, 110, 20, 110);
        Quadrilateral_F64 q12 = new Quadrilateral_F64(40, 102, 50, 102, 50, 112, 50, 112);

        List<Quadrilateral_F64> row0 = new ArrayList<>();
        row0.add(q00);
        row0.add(q01);
        row0.add(q02);
        List<Quadrilateral_F64> row1 = new ArrayList<>();
        row1.add(q10);
        row1.add(q11);
        row1.add(q12);
        List<List<Quadrilateral_F64>> sorted = new ArrayList<>();
        sorted.add(row0);
        sorted.add(row1);

        List<Quadrilateral_F64> unsorted = new ArrayList<>();
        unsorted.add(q02);
        unsorted.add(q11);
        unsorted.add(q00);
        unsorted.add(q10);
        unsorted.add(q12);
        unsorted.add(q01);

        assertEquals(sorted, GeometryUtils.sortRowWise(unsorted));
    }
}
