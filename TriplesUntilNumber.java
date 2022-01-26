package helloworld;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TriplesUntilNumber {

	public static void main(String[] args) {

		

		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		System.out.println(pqr_N(n));
		System.out.println(pqr_N_2(n));
		// p*q*r<=N
		
	}

	
	// Logic 1 Naive approach
	// Approach 1 TC O(n^3) 
	// Space Complexity ~O(sqrt(N)) x O(N)/O(sqrt(N)) x  O(N) / O(N/sqrt(N))==
	//therefore SC== O(N/sqrt(N))
	
	private static int pqr_N(int n) {
		int count=0;
		Set<String> st = new HashSet<String>();

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					if (i * j * k <= n) {

						String str = "";
						int arr[]=new int[3];
						arr[0]=i;arr[1]=j;arr[2]=k;
						Arrays.sort(arr);
						for (int l : arr) {
							str+=l+"-";
						}

						if (!st.contains(str)) {
							st.add(str);
							count++;
							System.out.println(count+" "+str);
						}
					}
					else {
						break;
					}
				}
			}
		}

		//System.out.println(st.size());
		return st.size();
	}
	
	// Approach 2

	//TC  ~O(sqrt(N)) x O(N)/O(sqrt(N)) x  O(N) / O(N/sqrt(N))
	//SC  ~O(sqrt(N)) x O(N)/O(sqrt(N)) x  O(N) / O(N/sqrt(N))
	
	private static int pqr_N_2(int n) {
		int count=0;
		Set<String> st = new HashSet<String>();

		for (int i = 1; i <= Math.cbrt(n)+1; i++) {
			for (int j = i; j <= n/i+1; j++) {
				for (int k = j; k <= n/(i*j)+1; k++) {
					if (i * j * k <= n) {

						String str = "";
						int arr[]=new int[3];
						arr[0]=i;arr[1]=j;arr[2]=k;
						Arrays.sort(arr);
						for (int l : arr) {
							str+=l+"-";
						}

						if (!st.contains(str)) {
							st.add(str);
							count++;
							System.out.println(count+" "+str);
						}
					}
					else {
						break;
					}
				}
			}
		}

		//System.out.println(st.size());
		return st.size();
		
	}
	
}
