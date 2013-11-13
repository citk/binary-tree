package oblig3;

import java.util.*;

public class Oblig3Test
{
  public static void main(String[] args)
  {
    int antallFeil = 0;

    antallFeil += oppgave1();
    antallFeil += oppgave2();
    antallFeil += oppgave3();
    antallFeil += oppgave4();
    //antallFeil += oppgave5();
    //antallFeil += oppgave6();
    //antallFeil += oppgave7();
    //antallFeil += oppgave8();
    //antallFeil += oppgave9();

    if (antallFeil == 0)
    {
      System.out.println("Gratulerer!! Du passerte testen!");
    }
    else
    {
      System.out.println
        ("\nDette må forbedres. Du har minst " + antallFeil + " feil!");
    }
  }


  // OPPGAVE 1 ////////////////////////////////////////////////

  public static int oppgave1()
  {
    int antallFeil = 0;
    SBinTre2<Integer> tre = SBinTre2.lagTre();

    try
    {
      if (tre.antall(1) != 0)
      {
        antallFeil++;
        System.out.println("Oppgave 1a: En verdi er 0 ganger i et tomy tre!!");
      }
    }
    catch (Exception e)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 1b: Skal ikke kaste unntak i et tomt tre!\n"
        + "Da er antall forekomster av en verdi lik 0!");
    }

    tre.leggInn(10);

    if (tre.antall(10) != 1 || tre.antall(5) != 0 || tre.antall(15) != 0)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 1c: Metoden gir feil svar for et tre med kun en verdi!");
    }

    tre.nullstill();

    int[] a = {10,5,8,9,8,20,15,3,17,20,3,16,20};
    for (int k : a) tre.leggInn(k);

    int[] ant = {1,1,2,1,2,3,1,2,1,3,2,1,3};

    for (int i = 0; i < a.length; i++)
    {
      if (tre.antall(a[i]) != ant[i])
      {
        antallFeil++;
        System.out.println
          ("Oppgave 1d: Det er  " + ant[i] + " forekomster av " + a[i]);
      }
    }

    int[] b = {2,7,13,21};

    for (int i = 0; i < b.length; i++)
    {
      if (tre.antall(b[i]) != 0)
      {
        antallFeil++;
        System.out.println
          ("Oppgave f: Det er 0 forekomster av " + b[i]);
      }
    }
    return antallFeil;

  }  // Oppgave 1


  // OPPGAVE 2 ////////////////////////////////////////////////

  public static int oppgave2()
  {
    SBinTre2<Integer> tre = SBinTre2.lagTre();

    int antallFeil = 0;

    tre.leggInn(10);
    if (tre.antallIngenBarn() != 1 || tre.antallEttBarn() != 0
      || tre.antallToBarn() != 0 || tre.høyde() != 0)
    {
      antallFeil++;
      System.out.println
          ("Oppgave 2a: Feil i variabelverdiene for et tre med en node!");
    }

    tre.leggInn(5);
    if (tre.antallIngenBarn() != 1 || tre.antallEttBarn() != 1
      || tre.antallToBarn() != 0 || tre.høyde() != 1)
    {
      antallFeil++;
      System.out.println
          ("Oppgave 2b: Feil i variabelverdiene for et tre med to noder!");
    }

    tre.leggInn(15);
    if (tre.antallIngenBarn() != 2 || tre.antallEttBarn() != 0
      || tre.antallToBarn() != 1 || tre.høyde() != 1)
    {
      antallFeil++;
      System.out.println
          ("Oppgave 2c: Feil i variabelverdiene for et tre med tre noder!");
    }

    tre.leggInn(8);
    if (tre.antallIngenBarn() != 2 || tre.antallEttBarn() != 1
      || tre.antallToBarn() != 1 || tre.høyde() != 2)
    {
      antallFeil++;
      System.out.println
          ("Oppgave 2d: Feil i variabelverdiene for et tre med fire noder!");
    }

   tre.leggInn(3);
    if (tre.antallIngenBarn() != 3 || tre.antallEttBarn() != 0
      || tre.antallToBarn() != 2 || tre.høyde() != 2)
    {
      antallFeil++;
      System.out.println
          ("Oppgave 2e: Feil i variabelverdiene for et tre med fem noder!");
    }

    tre.leggInn(7);
    if (tre.antallIngenBarn() != 3 || tre.antallEttBarn() != 1
      || tre.antallToBarn() != 2 || tre.høyde() != 3)
    {
      antallFeil++;
      System.out.println
          ("Oppgave 2f: Feil i variabelverdiene for et tre med seks noder!");
    }

    return antallFeil;

  } // Oppgave 2


  // OPPGAVE 3 ////////////////////////////////////////////////

  public static int oppgave3()
  {
    int antallFeil = 0;
    SBinTre2<Integer> tre = SBinTre2.lagTre();

    try
    {
      tre.nestMin();
      antallFeil++;
      System.out.println("Oppgave 3a: Skal kaste unntak for et tomt tre!!");
    }
    catch (Exception e)
    {
      if (!(e instanceof NoSuchElementException))
      {
        antallFeil++;
        System.out.println
          ("Oppgave 3b: Kaster feil type unntak for et tomt tre!");
      }
    }

    tre.leggInn(10);

    try
    {
       tre.nestMin();
       antallFeil++;
       System.out.println
         ("Oppgave 3c: Skal kaste unntak for et tre med en verdi!");
    }
    catch (Exception e)
    {
      if (!(e instanceof NoSuchElementException))
      {
        antallFeil++;
        System.out.println
          ("Oppgave 3d: Kaster feil type unntak for et tre med en verdi!");
      }
    }

    tre.nullstill();

    tre.leggInn(2); tre.leggInn(1);

    if (tre.nestMin() != 2)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 3e: Feil når rotnodeverdien er nest minst!");
    }

    tre.nullstill();

    int[] a = new int[] {1,6,4,7,2,5,3};
    for (int k : a) tre.leggInn(k);

    if (tre.nestMin() != 2)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 3f: Feil når rotnodeverdien er minst!");
    }

    tre.nullstill();

    a = new int[] {5,4,3,2,1};
    for (int k : a) tre.leggInn(k);

    if (tre.nestMin() != 2)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 3g: Feil når den minste ikke har et høyre barn!");
    }

    tre.nullstill();

    a = new int[] {11,9,12,7,10,1,8,5,4,6,2,3};
    for (int k : a) tre.leggInn(k);

    if (tre.nestMin() != 2)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 3h: Feil når den første har et høyre barn!");
    }

    tre.nullstill();

    try
    {
      tre.maks();
      antallFeil++;
      System.out.println("Oppgave 3i: Skal kaste unntak for et tomt tre!!");
    }
    catch (Exception e)
    {
      if (!(e instanceof NoSuchElementException))
      {
        antallFeil++;
        System.out.println
          ("Oppgave 3j: Kaster feil type unntak for et tomt tre!");
      }
    }

    tre.leggInn(10);

    if (tre.maks() != 10)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 3k: Rotnodeverdien er størst i et tre med en verdi!");
    }

    tre.leggInn(5); tre.leggInn(8);

    if (tre.maks() != 10)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 3l: Rotnodeverdien er størst når roten ikke har høyre barn!");
    }

    tre.leggInn(15); tre.leggInn(20); tre.leggInn(17);

    int verdi = tre.maks();

    if (tre.maks() != 20)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 3m: 20 er største verdi og ikke " + verdi + "!");
    }

    tre.nullstill();

    try
    {
      tre.nestMaks();
      antallFeil++;
      System.out.println("Oppgave 3n: Skal kaste unntak for et tomt tre!!");
    }
    catch (Exception e)
    {
      if (!(e instanceof NoSuchElementException))
      {
        antallFeil++;
        System.out.println
          ("Oppgave 3o: Kaster feil type unntak for et tomt tre!");
      }
    }

    tre.leggInn(10);

    try
    {
       tre.nestMaks();
       antallFeil++;
       System.out.println
         ("Oppgave 3p: Skal kaste unntak for et tre med en verdi!");
    }
    catch (Exception e)
    {
      if (!(e instanceof NoSuchElementException))
      {
        antallFeil++;
        System.out.println
          ("Oppgave 3q: Kaster feil type unntak for et tre med en verdi!");
      }
    }

    tre.leggInn(5);

    verdi = tre.nestMaks();
    if (verdi != 5)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 3r: 5 er nest største verdi og ikke " + verdi + "!");
    }

    tre.leggInn(8);

    verdi = tre.nestMaks();
    if (verdi != 8)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 3s: 8 er nest største verdi og ikke " + verdi + "!");
    }

    tre.leggInn(15);

    verdi = tre.nestMaks();
    if (verdi != 10)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 3t: 10 er nest største verdi og ikke " + verdi + "!");
    }

    tre.leggInn(20); tre.leggInn(17); tre.leggInn(19);

    verdi = tre.nestMaks();
    if (verdi != 19)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 3u: 19 er nest største verdi og ikke " + verdi + "!");
    }

    return antallFeil;

  }  // Oppgave 3


// OPPGAVE 4 ////////////////////////////////////////////////  

  public static void bytt(int[] a, int i, int j)
  {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public static boolean nestePermutasjon(int[] a)
  {
    int n = a.length, i = n - 2;  // i starter nest bakerst i a
    while (i >= 0 && a[i] > a[i+1]) i--;  // går forover i a

    // hvis i nå er lik -1, må a = {n,n-1, . . . , 2,1}
    if (i < 0) return false;  // a er den siste

    int j = n - 1;  // j starter bakerst i a
    for (int x = a[i]; a[j] < x; j--);     // den første større enn x
    bytt(a,i,j);    // bytter om

    for (j = n; ++i < --j; ) bytt(a,i,j);  // snur det til høyre for i
    return true;    // a inneholder en ny permutasjon
  }


  public static int oppgave4()
  {
    int antallFeil = 0;
    SBinTre2<Integer> tre = SBinTre2.lagTre();

    int[] a = {1,2,3,4,5};

    boolean flere = true;
    while (flere)
    {
      for (int k : a) tre.leggInn(k);
      int verdi = tre.minFjern();

      int sum =
        tre.antallIngenBarn() + tre.antallEttBarn() + tre.antallToBarn();

      String utskrift = tre.toString();

      if (verdi != 1)
      {
        antallFeil++;
        System.out.println
          ("Oppgave 4a: Når treet bygges med tabellen\n"
            + Arrays.toString(a) + " blir feil verdi fjernet!");
        break;
      }

      if (sum != tre.antall())
      {
        antallFeil++;
        System.out.println
          ("Oppgave 4b: Når treet bygges med tabellen\n"
            + Arrays.toString(a) +
            " får variablene feil verdi etter fjerning!");
        break;
      }

      if (!utskrift.equals("[2, 3, 4, 5]"))
      {
        antallFeil++;
        System.out.println(utskrift);
        System.out.println
          ("Oppgave 4c: Når treet bygges med tabellen\n"
            + Arrays.toString(a) +
            " blir ikke treet korrekt etter fjerningen!");
        break;
      }

      tre.nullstill();

      flere = nestePermutasjon(a);
    }

    return antallFeil;
  }


  // OPPGAVE 5 ////////////////////////////////////////////////

  public static int oppgave5()
  {
    int antallFeil = 0;
    SBinTre2<Integer> tre = SBinTre2.lagTre();

    if (tre.maksFjernAlle() != 0)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 5a: Skal returnere 0 for et tomt tre!");
    }

    int[] a = {10};
    for (int k : a) tre.leggInn(k);

    if (tre.maksFjernAlle() != 1)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 5b: Det er kun en verdi som er fjernet!");
    }

    if (tre.antall() != 0)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 5c: Feil i oppdateringen av antall!!");
    }

    String s1 = "[]";

   if (!s1.equals(tre.toString()))
    {
      antallFeil++;
      System.out.println
        ("Oppgave 5d: Det har blitt en feil i treet!");
    }

    tre.nullstill();
    a = new int[] {10,8,9};
    for (int k : a) tre.leggInn(k);

    if (tre.maksFjernAlle() != 1)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 5e: Det er kun en verdi som er fjernet!");
    }

    if (tre.antall() != 2)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 5f: Feil i oppdateringen av antall!!");
    }

    String s2 = "[8, 9]";

   if (!s2.equals(tre.toString()))
    {
      antallFeil++;
      System.out.println
        ("Oppgave 5g: Det har blitt en feil i treet!");
    }

    tre.nullstill();
    a = new int[] {10,10,10};
    for (int k : a) tre.leggInn(k);

    if (tre.maksFjernAlle() != 3)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 5h: Det er tre verdier som skal være fjernet!");
    }

    if (tre.antall() != 0)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 5i: Feil i oppdateringen av antall!!");
    }

    String s3 = "[]";

    if (!s3.equals(tre.toString()))
    {
      antallFeil++;
      System.out.println
        ("Oppgave 5j: Det har blitt en feil i treet!");
    }

    tre.nullstill();
    a = new int[] {2,4,6,1,6,3,6,5,6};
    for (int k : a) tre.leggInn(k);

    if (tre.maksFjernAlle() != 4)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 5k: Det er fire verdier som skal være fjernet!");
    }

    if (tre.antall() != 5)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 5l: Feil i oppdateringen av antall!!");
    }

    String s4 = "[1, 2, 3, 4, 5]";
    if (!s4.equals(tre.toString()))
    {
      antallFeil++;
      System.out.println
        ("Oppgave 5m: Det har blitt en feil i treet!");
    }

    tre.nullstill();

    a = new int[] {1,2,3,4,5};

    boolean flere = true;
    while (flere)
    {
      for (int k : a) tre.leggInn(k);
      int antall = tre.maksFjernAlle();

      int sum =
        tre.antallIngenBarn() + tre.antallEttBarn() + tre.antallToBarn();

      String utskrift = tre.toString();

      if (antall != 1)
      {
        antallFeil++;
        System.out.println
          ("Oppgave 5n: Når treet bygges med tabellen\n"
            + Arrays.toString(a) + " returnerer metoden feil antall!");
        break;
      }

      if (sum != tre.antall())
      {
        antallFeil++;
        System.out.println
          ("Oppgave 5o: Når treet bygges med tabellen\n"
            + Arrays.toString(a) +
            " får variablene feil verdi etter fjerning!");
        break;
      }

      if (!utskrift.equals("[1, 2, 3, 4]"))
      {
        antallFeil++;
        System.out.println(utskrift);
        System.out.println
          ("Oppgave 5p: Når treet bygges med tabellen\n"
            + Arrays.toString(a) +
            " blir ikke treet korrekt etter fjerningen!");
        break;
      }

      tre.nullstill();

      flere = nestePermutasjon(a);
    }

    tre.nullstill();

    a = new int[] {0,1,2,3,4,5,6};
    int[] b = {1,2,3,4,5,5,5};

    flere = true;
    while (flere)
    {
      for (int k : a) tre.leggInn(b[k]);
      int antall = tre.maksFjernAlle();

      int sum =
        tre.antallIngenBarn() + tre.antallEttBarn() + tre.antallToBarn();

      String utskrift = tre.toString();

      if (antall != 3)
      {
        antallFeil++;

        int[] c = {b[a[0]],b[a[1]],b[a[2]],b[a[3]],b[a[4]],b[a[5]],b[a[6]]};

        System.out.println
          ("Oppgave 5q: Når treet bygges med tabellen\n"
            + Arrays.toString(c) + " returnerer metoden feil antall!");
        break;
      }

      if (sum != tre.antall())
      {

        int[] c = {b[a[0]],b[a[1]],b[a[2]],b[a[3]],b[a[4]],b[a[5]],b[a[6]]};

        antallFeil++;
        System.out.println
          ("Oppgave 5r: Når treet bygges med tabellen\n"
            + Arrays.toString(c) +
            " får variablene feil verdi etter fjerning!");
        break;
      }

      if (!utskrift.equals("[1, 2, 3, 4]"))
      {
        int[] c = {b[a[0]],b[a[1]],b[a[2]],b[a[3]],b[a[4]],b[a[5]],b[a[6]]};

        antallFeil++;
        System.out.println
          ("Oppgave 5s: Når treet bygges med tabellen\n"
            + Arrays.toString(c) +
            " blir ikke treet korrekt etter fjerningen!");
        break;
      }

      tre.nullstill();

      flere = nestePermutasjon(a);
    }

    return antallFeil;

  } // Oppgave 5 


  // OPPGAVE 6 ////////////////////////////////////////////////

  public static int oppgave6()
  {
    int antallFeil = 0;
    SBinTre2<Integer> tre = SBinTre2.lagTre();

    String s1 = "[]";

    if (!s1.equals(tre.høyreGren()))
    {
      antallFeil++;
      System.out.println
        ("Oppgave 6a: Skal returnere " + s1 + " for et tomt tre!");
    }

    int[] a = {10};
    for (int k : a) tre.leggInn(k);

    String s2 = "[10]";

    if (!s2.equals(tre.høyreGren()))
    {
      antallFeil++;
      System.out.println
        ("Oppgave 6b: Skal returnere " + s2 + " her!");
    }

    tre.nullstill();
    a = new int[] {5,4,3,2,1};
    for (int k : a) tre.leggInn(k);

    String s3 = "[5, 4, 3, 2, 1]";

    if (!s3.equals(tre.høyreGren()))
    {
      antallFeil++;
      System.out.println
        ("Oppgave 6c: Skal returnere " + s3 + " her!");
    }

    tre.nullstill();
    a = new int[] {7,2,5,9,8,14,1,13,4,10,6,12,3,11};
    for (int k : a) tre.leggInn(k);

    String s4 = "[7, 9, 14, 13, 10, 12, 11]";

    if (!s4.equals(tre.høyreGren()))
    {
      antallFeil++;
      System.out.println
        ("Oppgave 6d: Skal returnere " + s4 + " her!");
    }

    tre.nullstill();
    a = new int[] {1,2,3,4,5};
    for (int k : a) tre.leggInn(k);

    String s5 = "[1, 2, 3, 4, 5]";

    if (!s5.equals(tre.høyreGren()))
    {
      antallFeil++;
      System.out.println
        ("Oppgave 6e: Skal returnere " + s5 + " her!");
    }

    return antallFeil;

  }  // Oppgave 6  


  // OPPGAVE 7 ////////////////////////////////////////////////

  public static int oppgave7()
  {
    int antallFeil = 0;
    SBinTre2<Integer> tre = SBinTre2.lagTre();

    String s1 = "[]";

    if (!s1.equals(tre.omvendtString()))
    {
      antallFeil++;
      System.out.println
        ("Oppgave 7a: Skal gi " + s1 + " for et tomt tre!");
    }

    int[] a = {10};
    for (int k : a) tre.leggInn(k);

    String s2 = "[10]";

    if (!s2.equals(tre.omvendtString()))
    {
      antallFeil++;
      System.out.println
        ("Oppgave 7b: Skal gi " + s2 + " her!");
    }

    tre.nullstill();
    a = new int[] {5,4,3,2,1};
    for (int k : a) tre.leggInn(k);

    String s3 = "[5, 4, 3, 2, 1]";

    if (!s3.equals(tre.omvendtString()))
    {
      antallFeil++;
      System.out.println
        ("Oppgave 7c: Skal gi " + s3 + " her!");
    }

    tre.nullstill();
    a = new int[] {7,2,5,9,8,14,1,13,4,10,6,12,3,11};
    for (int k : a) tre.leggInn(k);

    String s4 = "[14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1]";

    if (!s4.equals(tre.omvendtString()))
    {
      antallFeil++;
      System.out.println
        ("Oppgave 7d: Skal returnere " + s4 + " her!");
    }

    // Sjekker med omvendtString om maksFjern er ok

    tre.nullstill();
    a = new int[] {10,5,15,13,15,14,12,15,14};
    for (int k : a) tre.leggInn(k);
    tre.maksFjernAlle();

    String s5 = "[14, 14, 13, 12, 10, 5]";

    if (!s5.equals(tre.omvendtString()))
    {
      antallFeil++;
      System.out.println
        ("Oppgave 7e: Skal returnere " + s5 + " her!"
        + "\nKan skyldes en feil i metoden maksFjern?");
    }

    return antallFeil;

  }  // Oppgave 7    


  // OPPGAVE 8 ////////////////////////////////////////////////

  public static int oppgave8()
  {
    int antallFeil = 0;
    SBinTre2<Integer> tre = SBinTre2.lagTre();

    try
    {
      int n = tre.grener().length;
      if (n != 0)
      {
        antallFeil++;
        System.out.println("Oppgave 8a: Feil returverdi for en tomt tre!");
      }
    }
    catch (Exception e)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 8b: Skal ikke kaste unntak for et tomt tre!");
    }

    tre.leggInn(10);

    if (tre.grener().length != 1)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 8c: Treet har kun en gren!");
    }

    String s1 = "[10]";

    if (!s1.equals(tre.grener()[0]))
    {
      antallFeil++;
      System.out.println
        ("Oppgave 8d: Treet har kun den ene grenen " + s1 + "!");
    }

    int[] a = {9,8,7,6};
    for (int k : a) tre.leggInn(k);

    if (tre.grener().length != 1)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 8e: Treet har kun en gren!");
    }

    String s2 = "[10, 9, 8, 7, 6]";

    if (!s2.equals(tre.grener()[0]))
    {
      antallFeil++;
      System.out.println
        ("Oppgave 8f: Treet har kun den ene grenen " + s2 + "!");
    }

    tre.nullstill();
    a = new int[] {5,2,8,1,4,6,9,3,7};
    for (int k : a) tre.leggInn(k);

    String[] t = tre.grener();

    if (t.length != 4)
    {
      antallFeil++;
      System.out.println
        ("Oppgave 8g: Treet har fire grener!");
    }

    String s3 = "[[5, 2, 1], [5, 2, 4, 3], [5, 8, 6, 7], [5, 8, 9]]";

    if (!s3.equals(Arrays.toString(t)))
    {
      antallFeil++;
      System.out.println
        ("Oppgave 8h: Treet har disse grenenen:");
      for (String gren : t) System.out.println(gren);
    }

    return antallFeil;

  }  // Oppgave 8      


  // OPPGAVE 9 ////////////////////////////////////////////////

  public static int oppgave9()
  {
    int antallFeil = 0;
    SBinTre2<Integer> tre = SBinTre2.lagTre();

    Iterator<Integer> i = tre.bladnodeiterator();

    try
    {
      i.next();
      antallFeil++;
      System.out.println("Oppgave 9a: Skal kaste unntak når treet er tomt!");
    }
    catch (Exception e)
    {
      if (!(e instanceof NoSuchElementException))
      {
        antallFeil++;
        System.out.println
          ("Oppgave 9b: Skal kaste NoSuchElementException her!");
      }
    }

    tre.leggInn(10);
    i = tre.bladnodeiterator();

    if (i.next().compareTo(10) != 0)
    {
      antallFeil++;
      System.out.println("Oppgave 9c: Her skal next() returnere 10!");
    }

    try
    {
      i.next();
      antallFeil++;
      System.out.println
        ("Oppgave 9d: Skal kaste unntak når det ikke er flere igjen!");
    }
    catch (Exception e)
    {
      if (!(e instanceof NoSuchElementException))
      {
        antallFeil++;
        System.out.println
          ("Oppgave 9e: Skal kaste NoSuchElementException her!");
      }
    }

    tre.nullstill();
    int[] a = {5,2,8,1,4,6,9,3,7};
    for (int k : a) tre.leggInn(k);

    i = tre.bladnodeiterator();

    int[] b = new int[tre.grener().length];
    int[] c = {1,3,7,9};

    for (int j = 0; j < b.length; j++) b[j] = i.next();

    if (!Arrays.equals(b, c))
    {
      antallFeil++;
      String bladnoder = Arrays.toString(c);
      System.out.println
        ("Oppgave 9f: Treet har disse bladnodeverdiene: " + bladnoder);
    }

    i = tre.bladnodeiterator();
    tre.leggInn(1);

    try
    {
      i.next();
      antallFeil++;
      System.out.println
        ("Oppgave 9g: Skal kaste unntak når treet er endret!");
    }
    catch (Exception e)
    {
      if (!(e instanceof ConcurrentModificationException))
      {
        antallFeil++;
        System.out.println
          ("Oppgave 9h: Skal kaste ConcurrentModificationException her!");
      }
    }

    return antallFeil;

  }  // Oppgave 9      


} // Oblig3Test
