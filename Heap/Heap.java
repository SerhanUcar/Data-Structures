
package Heap;


class dugum {

    int no;

    dugum(int no) {
        this.no = no;
    }
}

class agac {

    dugum[] d;
    dugum[] d1;
    int elemanSayisi;
    int elemanSayisii;

    agac(int N) {
        d = new dugum[N];
        d1 = new dugum[N];
        elemanSayisi = -1;
        elemanSayisii = -1;
    }
    dugum[] dizi;

    void siraliEkle(dugum[] d1, dugum[] d2) {
        elemanSayisi = -1;
        dizi = new dugum[d1.length + d2.length];
        for (int i = 0; i < d1.length; i++) {
            dizi[i] = d1[i];
        }
        for (int i = d1.length; i < dizi.length; i++) {
            dizi[i] = d2[i - 3];
        }

        for (int i = 0; i < dizi.length; i++) {
            ekle(dizi[i]);
        }

    }

    void ekle(dugum yeni) { //Heap'e eleman ekleme
        elemanSayisi++;
        d[elemanSayisi] = yeni;
        int no = elemanSayisi;
        int ata = ata(no);

        while (ata >= 0 && d[ata].no > d[no].no) {
            dugum ara = d[ata];
            d[ata] = d[no];
            d[no] = ara;
            no = ata;
            ata = ata(no);
        }
    }
    
    int sil(dugum d[], int n) { //Heap'ten eleman silme
        dugum sonEleman = d[n - 1];
        d[0] = sonEleman;
        n = n - 1;
        heapify(d, n, 0);

        return n;
    }

    void heapify(dugum d[], int n, int i) { //Min Heap olarak sıralama
        int enKucuk = i;
        int sol = sol(i);
        int sag = sag(i);

        if (sol < n && d[sol].no < d[i].no) {
            enKucuk = sol;
        }
        if (sag < n && d[sag].no < d[enKucuk].no) {
            enKucuk = sag;
        }
        if (enKucuk != i) {
            dugum tmp = d[i];
            d[i] = d[enKucuk];
            d[enKucuk] = tmp;
            heapify(d, n, enKucuk);
        }
    }

    void maxHeap(dugum d[], int n) { //Max Heap sıralama metoduna yollama
        for (int i = (n - 2) / 2; i >= 0; i--) {
            MaxHeapify(d, i, n);
        }
    }

    void MaxHeapify(dugum d[], int i, int n) { //Max Heap olarak sıralama
        int sol = sol(i);
        int sag = sag(i);
        int enBuyuk = i;
        if (sol < n && d[sol].no > d[i].no) {
            enBuyuk = sol;
        }
        if (sag < n && d[sag].no > d[enBuyuk].no) {
            enBuyuk = sag;
        }
        if (enBuyuk != i) {
            dugum tmp = d[i];
            d[i] = d[enBuyuk];
            d[enBuyuk] = tmp;
            MaxHeapify(d, enBuyuk, n);
        }
    }

    boolean minHeapmi(dugum[] d, int n) { //Min Heap mi yoksa Max Heap mi olduğunun kontrolü
        for (int i = 0; i < n / 2; i++) {
            if ((d[i].no > d[sol(i)].no) || (d[i].no) > d[sag(i)].no) {
                return false;
            }
        }
        return true;
    }

    void goster(dugum[] d, int n) { //Dugumun elemanlarındaki numaraları gösterir
        for (int i = 0; i < n; i++) {
            System.out.print(d[i].no + " ");
        }
    }

    int ata(int no) {
        int ata = (no - 1) / 2;
        return ata;
    }

    int sol(int no) {
        int sol = (2 * no) + 1;
        return sol;
    }

    int sag(int no) {
        int sag = (2 * no) + 2;
        return sag;
    }
}



public class Heap {

    public static void main(String[] args) {
        dugum d1 = new dugum(5);
        dugum d2 = new dugum(10);
        dugum d3 = new dugum(7);
        dugum d4 = new dugum(12);
        dugum d5 = new dugum(12);
        dugum d6 = new dugum(8);
        dugum d7 = new dugum(9);
        dugum d8 = new dugum(13);
        dugum d9 = new dugum(6);
        dugum d10 = new dugum(11);

        dugum d11 = new dugum(1);
        dugum d12 = new dugum(2);
        dugum d13 = new dugum(3);
        dugum d21 = new dugum(6);
        dugum d22 = new dugum(7);
        dugum d23 = new dugum(8);
        dugum d24 = new dugum(9);
        dugum[] dizi1 = {d11, d12, d13};
        dugum[] dizi2 = {d21, d22, d23, d24};

        agac a = new agac(4);
        agac a2 = new agac(3);
        agac a3 = new agac(7);
        a.ekle(d1);
        a.ekle(d2);
        a.ekle(d3);
        a.ekle(d4);
        dugum[] heap1 = new dugum[4];
        heap1 = a.d;

        a2.ekle(d6);
        a2.ekle(d7);
        a2.ekle(d8);
        dugum[] heap2 = new dugum[3];
        heap2 = a2.d;
        a.goster(a.d, a.d.length);
        System.out.println(" ");
        a.goster(a2.d, a2.d.length);
        a.goster(a.d, a.d.length);
        System.out.println("");
        a2.goster(a2.d, a2.d.length);

    }

}
