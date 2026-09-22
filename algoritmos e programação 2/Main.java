public class Main {

    private static int particao(int e, int d, String[] a) {
        String pivo, aux;
        int i, j;
        pivo = a[d];
        i = e - 1;
        j = d;
        do {
            do {
                i = i + 1;
                // Procura um elemento maior ou igual ao pivô em ordem alfabética
            } while ((a[i].compareTo(pivo) < 0) && (i < d));

            do {
                j = j - 1;
                // Procura um elemento menor ou igual ao pivô em ordem alfabética
            } while ((a[j].compareTo(pivo) > 0) && (j > 0));

            // Realiza a troca de valores
            aux = a[i];
            a[i] = a[j];
            a[j] = aux;
        } while (j > i);

        // Colocando o pivô a[d] em seu lugar definitivo
        a[j] = a[i];
        a[i] = a[d];
        a[d] = aux;
        return i;
    }

    public static void quickSort(int e, int d, String[] a) {
        int i;
        if (d > e) {
            i = particao(e, d, a);
            /* Particionando o vetor */
            quickSort(e, i - 1, a);
            quickSort(i + 1, d, a);
        }
    }

    public static void main(String[] args) {
        String[] palavras = {
                "Banana", "Guilherme", "Gato", "Goiaba", "Gaviota",
                "bola", "Rato", "Pena", "Elden ring"
        };

        System.out.println("Vetor original:");
        for (String item : palavras) {
            System.out.print("[" + item + "] ");
        }

        // Executa o Quick Sort
        quickSort(0, palavras.length - 1, palavras);

        System.out.println("\n\nVetor ordenado:");
        for (String item : palavras) {
            System.out.print("[" + item + "] ");
        }
    }
}