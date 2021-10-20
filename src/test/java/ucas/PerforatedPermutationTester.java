package ucas;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerforatedPermutationTester {

    @Test
    public void testEmptyPermutation() {
        List<UCAS> pPermutation = new ArrayList<>();
        assertEquals(pPermutation, UCAS.patchPermutation(pPermutation, 0));
    }

    @Test
    public void test64() {
        List<UCAS> pPermutation = new ArrayList<>();
        List<UCAS> aPermutation = new ArrayList<>();
        final int N = 64;

        UCAS[] input = {new UCAS("BQ"), new UCAS("BF"), new UCAS("BR"), new UCAS("BT"), new UCAS("BB"), new UCAS("C"), new UCAS("CL"), new UCAS("N"), new UCAS("BH"), new UCAS("K"), new UCAS("BL"), new UCAS("BJ"), new UCAS("BP"), new UCAS("E"), new UCAS("F"), new UCAS("CJ"), new UCAS("G"), new UCAS("R"), new UCAS("V")};
        UCAS[] output = {new UCAS("A"), new UCAS("B"), new UCAS("D"), new UCAS("H"), new UCAS("I"), new UCAS("J"), new UCAS("L"), new UCAS("M"), new UCAS("O"), new UCAS("P"), new UCAS("Q"), new UCAS("S"), new UCAS("T"), new UCAS("U"), new UCAS("W"), new UCAS("X"), new UCAS("Y"), new UCAS("Z"), new UCAS("BA"), new UCAS("BC"), new UCAS("BD"), new UCAS("BE"), new UCAS("BG"), new UCAS("BI"), new UCAS("BK"), new UCAS("BM"), new UCAS("BN"), new UCAS("BO"), new UCAS("BQ"), new UCAS("BF"), new UCAS("BR"), new UCAS("BS"), new UCAS("BT"), new UCAS("BB"), new UCAS("C"), new UCAS("BU"), new UCAS("BV"), new UCAS("BW"), new UCAS("BX"), new UCAS("BY"), new UCAS("BZ"), new UCAS("CA"), new UCAS("CB"), new UCAS("CC"), new UCAS("CD"), new UCAS("CE"), new UCAS("CF"), new UCAS("CG"), new UCAS("CH"), new UCAS("CI"), new UCAS("CK"), new UCAS("CL"), new UCAS("N"), new UCAS("BH"), new UCAS("K"), new UCAS("BL"), new UCAS("BJ"), new UCAS("BP"), new UCAS("E"), new UCAS("F"), new UCAS("CJ"), new UCAS("G"), new UCAS("R"), new UCAS("V")};

        for (int idx = 0; idx < input.length; idx++) {
            pPermutation.add(input[idx]);
        }

        for (int idx = 0; idx < N; idx++) {
            aPermutation.add(output[idx]);
        }

        assertEquals(aPermutation, UCAS.patchPermutation(pPermutation, N));
    }

    @Test
    public void testSingularPermutation() {
        List<UCAS> pPermutation = new ArrayList<>();
        List<UCAS> aPermutation = new ArrayList<>();
        aPermutation.add(new UCAS(0));
        assertEquals(aPermutation, UCAS.patchPermutation(pPermutation, 64));
    }

    @Test
    public void testSmallPermutationWithSeedString() {
        List<UCAS> pPermutation = new ArrayList<>();
        List<UCAS> aPermutation = new ArrayList<>();
        pPermutation.add(new UCAS(0));
        aPermutation.add(new UCAS(0));
        assertEquals(aPermutation, UCAS.patchPermutation(pPermutation, 1));
    }

    @Test
    public void testCompletePermutation() {
        List<UCAS> pPermutation = new ArrayList<>();
        List<UCAS> aPermutation = new ArrayList<>();
        final int N = 20;

        for (int id = 0; id < N; id++) {
            pPermutation.add(new UCAS(id));
            aPermutation.add(new UCAS(id));
        }
        assertEquals(aPermutation, UCAS.patchPermutation(pPermutation, N));
    }

    @Test
    public void testPermutationInOrder() {
        List<UCAS> pPermutation = new ArrayList<>();
        List<UCAS> aPermutation = new ArrayList<>();
        final int N = 20;

        for (int id = 0; id < N / 2; id++) {
            pPermutation.add(new UCAS(id));
        }

        for (int id = 0; id < N; id++) {
            aPermutation.add(new UCAS(id));
        }
        assertEquals(aPermutation, UCAS.patchPermutation(pPermutation, N));
    }

    @Test
    public void testPermutationOutOfOrder() {
        List<UCAS> pPermutation = new ArrayList<>();
        List<UCAS> aPermutation = new ArrayList<>();
        final int N = 11;

        int[] input_ids = {3, 1, 8};
        int[] output_ids = {0, 2, 3, 1, 4, 5, 6, 7, 8, 9, 10};

        for (int idx = 0; idx < input_ids.length; idx++) {
            pPermutation.add(new UCAS(input_ids[idx]));
        }

        for (int idx = 0; idx < N; idx++) {
            aPermutation.add(new UCAS(output_ids[idx]));
        }

        assertEquals(aPermutation, UCAS.patchPermutation(pPermutation, N));
    }

    @Test
    public void testCompletePermutationOutOfOrder() {
        List<UCAS> pPermutation = new ArrayList<>();
        List<UCAS> aPermutation = new ArrayList<>();
        final int N = 5;

        int[] input_ids = {3, 1, 4, 2, 0};
        int[] output_ids = {3, 1, 4, 2, 0};

        for (int idx = 0; idx < input_ids.length; idx++) {
            pPermutation.add(new UCAS(input_ids[idx]));
        }

        for (int idx = 0; idx < N; idx++) {
            aPermutation.add(new UCAS(output_ids[idx]));
        }

        assertEquals(aPermutation, UCAS.patchPermutation(pPermutation, N));
    }

    @Test
    public void testMostlyCompletePermutationOutOfOrder() {
        List<UCAS> pPermutation = new ArrayList<>();
        List<UCAS> aPermutation = new ArrayList<>();
        final int N = 6;

        int[] input_ids = {3, 1, 4, 2, 0};
        int[] output_ids = {3, 1, 4, 2, 0, 5};

        for (int idx = 0; idx < input_ids.length; idx++) {
            pPermutation.add(new UCAS(input_ids[idx]));
        }

        for (int idx = 0; idx < N; idx++) {
            aPermutation.add(new UCAS(output_ids[idx]));
        }

        assertEquals(aPermutation, UCAS.patchPermutation(pPermutation, N));
    }

}
