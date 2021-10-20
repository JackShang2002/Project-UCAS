package ucas;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;

public class UCAS implements Comparable<UCAS> {
    private static final char[] alphabets = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* ucas_id is ths numeric identifier for the UCAS */
    private int ucas_id;

    /* ucas is the String that holds the UCAS */
    private String ucas;

    /*
     *  Representation Invariant:
     *  It should always hold that ucas == getUCAS(ucas_id)
     */

    /**
     * Create a UCAS from a given numeric identifier
     *
     * @param id the numeric identifier of the UCAS to create
     */
    public UCAS(int id) {
        ucas_id = id;
        if (ucas_id < 0) {
            throw new IllegalArgumentException("argument should be >= 0");
        }

        ucas = getUCAS(id);
    }

    /**
     * Create a UCAS from a given String
     *
     * @param seed the string to create the object from, is not <tt>null</tt> and contains only upper-case alphabetic characters
     */
    public UCAS(String seed) {

        int id = 0;

        char[] arrayVal = seed.toCharArray();
        //I know the parameters specify that it has to be not null and contains only upper-case alphabetic characters, but this is just for safety in case the user does not follow it. Personal habit.
        for (char c : arrayVal) {
            if (c < 65 || c > 90) {
                throw new IllegalArgumentException("argument should be uppercase alphabets");
            }
        }

        for (int i = seed.length() - 1; i > -1; i--) {
            for (int length = 0; length < seed.length(); length++) {
                id += (arrayVal[length] - 65) * pow(26, i);
            }
        }


        ucas_id = id;
        if (ucas_id < 0) {
            throw new IllegalArgumentException("argument should be >= 0");
        }

        ucas = getUCAS(id);
    }




    /**
     * Return the String that represents the UCAS given a numeric id
     * @param id the numeric id of the (UCAS) String to obtain
     * @return the UCAS the corresponds to {@code id}.
     */
    private static String getUCAS(int id) {
        if (id < 0) {
            throw new IllegalArgumentException("UCAS id should be >= 0");
        }

        StringBuilder sb = new StringBuilder();
        do {
            int ch_idx = id % alphabets.length;
            sb.insert(0, alphabets[ch_idx]);
            id = id / alphabets.length;
        } while (id > 0);
        return sb.toString();
    }

    public int getID(){
        return ucas_id;
    }

    public String getString(){
        return ucas;
    }

    /**
     * Given a punctured permutation and {@code upperbound}, which represents the number of entries in the initial permutation, reconstruct the permutation from which the pruned permutation could have been created, and if multiple such permutations exist then construct the permutation that is lexicographically the smallest
     * @param puncturedPermutation the pruned permutation, is {@code not null}
     * @param upperbound the number of entries in the original permutation, {@code upperbound >= puncturedPermutation.size()}
     * @return the lexicographically smallest permutation with {@code upperbound} entries that could have been punctured to obtain the given {@code puncturedPermutation}
     */
    public static List<UCAS> patchPermutation(List<UCAS> puncturedPermutation, int upperbound) {


        List<UCAS> returnArr = new ArrayList<>();

        //If there is an empty input, but upperbound is 1.
        if (upperbound == 1) {
            returnArr.add(new UCAS(0));
            return returnArr;
        } else {

            //Adds every element missing into the array that is going to be returned, as well as all elements that are in the original punctured array.
            if (upperbound > 0) {
                for (int length = 0; length < puncturedPermutation.size(); length++) {

                        for (int id = 0; id < puncturedPermutation.get(length).ucas_id; id++) {

                            UCAS dummyU = new UCAS(id);

                            if (!returnArr.contains(dummyU) && !puncturedPermutation.contains(dummyU)) {
                                returnArr.add(returnArr.size(), new UCAS(id));

                            }
                        }

                    returnArr.add(returnArr.size(), new UCAS(puncturedPermutation.get(length).ucas_id));
                }

                //Adds every element up to UCAS(upperbound-1) behind the last element of the array that is going to be returned.
                for (int id = returnArr.size(); id < upperbound; id++) {
                    returnArr.add(returnArr.size(), new UCAS(id));
                }
            }

            return returnArr;
        }
    }


    /* You should not have to change any of the methods below **/

    /**
     * Generate the UCAS with next identifier
     * @return the UCAS with next identifier
     */
    public UCAS getNext() {
        int id = ucas_id + 1;
        return new UCAS(id);
    }

    /**
     * Generate the UCAS with the previous identifier and if no such UCAS exists then return a UCAS that is identical to the current UCAS
     * @return the UCAS with the previous identifer
     */
    public UCAS getPrev() {
        int id = (ucas_id == 0 ? 0 : ucas_id - 1);
        return new UCAS(id);
    }

    /**
     *
     * @return a Stringified version of the UCAS
     */
    public String toString() {
        return ucas;
    }

    @Override
    public int compareTo(UCAS other) {
        return (ucas_id - other.ucas_id);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof UCAS)) {
            return false;
        }
        UCAS o_ucas = (UCAS) other;
        return (this.compareTo(o_ucas) == 0);
    }

}
