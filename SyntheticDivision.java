/**
 * Auther: Andrew Mackay
 * Originally created: 05/04/2017
 * Status: Working
 * Tested: Hand tested on a selection of polynomials.
 *         Needs further testing to be considered reliable.
 *
 * Program written to find the factors for a polynomial
 * Uses synthetic division
 * Enter args as coefficients including zeros
 *
 * For example "java SyntheticDivision 1 0 -1"
 * Will search for factors of x^2 - 1
 *
 * Another example
 * "java SyntheticDivision 1 2 -1 -2"
 * Will search for factors of x^3 + 2x^2 - x -2
 */
public class SyntheticDivision{
  public static String[] findFactors(String[] args){
    // holds the coefficients of the polynomial
    int[] coeff = new int[args.length];
    int range = Math.abs(Integer.valueOf(args[args.length-1]))+1;
    // converts input values to integers
    for (int i = 0; i < args.length; i++) {
      coeff[i] = Integer.valueOf(args[i]);
    }

    int p = 0;
    String[] factors = new String[range];

    // Checks 1 -> range
    for (int i = 1; i < range; i++){if (factorise(i, coeff)){factors[p] = ("x+" + i); p++;}}
    // Checks -1 -> -range
    for (int i = -1; i > (range * -1) ; i--){if (factorise(i, coeff)){factors[p] = ("x" + i); p++;}}

    return factors;
  }

  // Basic synthetic division algorithm
  public static boolean factorise(int n, int[] coeffs){
    int i = -1 * n;
    int carry = 0;
    int var = 0;
    for (int t : coeffs){
      var = carry + t;
      carry = i * var;
    }
    if (var == 0){return true;}
    else{return false;}
  }
}
