package com.atlikarinca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author birdal
 *
 */
public class AtliKarinca {

	public static void main(String[] args) {
		int R = -1, k = -1, N = -1, index = 0;
		boolean temp1 = true, temp2 = true;
		ArrayList<Integer> degisken_dizi = new ArrayList<Integer>();
		ArrayList<Integer> grupliste = new  ArrayList<Integer>();
		ArrayList<Integer> araliste = new  ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Sayýlarý Giriniz");
		String degiskenler = scan.nextLine();
		int i = 0, j = 0, toplam = 0, geneltoplam = 0;
		while (temp1 == true) {
			for (i = 0; i < degiskenler.length(); i++) {
				if (degiskenler.charAt(i) == ' ') {
					degisken_dizi.add(Integer.parseInt(degiskenler.substring(0, i)));
					degiskenler = degiskenler.substring(i + 1, degiskenler.length());
					i = 0;
				} 
			}
			if (i == (degiskenler.length())) {
				degisken_dizi.add(Integer.parseInt(degiskenler));
				temp1 = false;
			}
		}
		
		R = degisken_dizi.get(0);
		k = degisken_dizi.get(1);
		N = degisken_dizi.get(2);
		
		System.out.println(N + " Gruptaki Kiþi Sayýlarýný Giriniz");
		String grupsayilari = scan.nextLine();
		while (temp2 == true) {
			for (j = 0; j < grupsayilari.length(); j++) {
				if (grupsayilari.charAt(j) == ' ') {
					grupliste.add(Integer.parseInt(grupsayilari.substring(0,j)));
					grupsayilari = grupsayilari.substring(j+1, grupsayilari.length());
					j = 0;
				}
			}
			if (j == (grupsayilari.length())) {
				grupliste.add(Integer.parseInt(grupsayilari));
				temp2 = false;
			}
		}
		int l = 0;
		while (R > 0) {
			for (l = 0; l < grupliste.size(); l++) {
				
				toplam = toplam + grupliste.get(l);
				index++;
				if (toplam > k) {
					toplam = toplam - grupliste.get(l);
					index--;
					geneltoplam = geneltoplam + toplam;
					for (int m = 0; m < index; m++) {
						araliste.add(grupliste.get(0));
						grupliste.remove(0);
						grupliste.add(araliste.get(0));
						araliste.remove(0);
					}
					index = 0;
					toplam = 0;
					l = grupliste.size()+1;
					--R;
				}
			}
		}
		System.out.println("Toplam Kazanýlan Para : " + geneltoplam + " Lira");
	}
}