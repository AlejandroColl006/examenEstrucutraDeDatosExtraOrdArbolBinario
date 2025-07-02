package arbolbinario;

public class ArbolUtil {

    public static boolean mismosNegativos(ArbolBinario<Integer> arbol) throws Exception {
        if (arbol == null || arbol.esVacio()) return true;

        int numerosNegativosIzq = contarNegativos(arbol.hijoIzq());
        int numerosNegativosDer = contarNegativos(arbol.hijoDer());

        return numerosNegativosIzq == numerosNegativosDer;
    }

    private static int contarNegativos(ArbolBinario<Integer> arbol) throws Exception {
        if (arbol == null || arbol.esVacio()) return 0;

        int cuenta = 0;

        if (arbol.raiz().dato < 0) {
            cuenta++;
        }

        cuenta += contarNegativos(arbol.hijoIzq());
        cuenta += contarNegativos(arbol.hijoDer());

        return cuenta;
    }
}

class Main{
    private static ArbolBinario<Integer> arbol;

    public static void main(String[] args) {
        try {
            NodoBinario<Integer> nodoMenos1 = new NodoBinario<>(-1);
            NodoBinario<Integer> nodo2 = new NodoBinario<>(2, nodoMenos1, null);
            NodoBinario<Integer> nodoMenos5 = new NodoBinario<>(-5);
            NodoBinario<Integer> nodo4 = new NodoBinario<>(4, nodoMenos5, null);
            NodoBinario<Integer> raiz = new NodoBinario<>(9, nodo2, nodo4);
            ArbolBinario<Integer> arbolBinario = new ArbolBinario<>(raiz);

            boolean resultado = ArbolUtil.mismosNegativos(arbol);
            System.out.println("Resultado: " + resultado);

            NodoBinario<Integer> nodoMenos2 = new NodoBinario<>(-2);
            NodoBinario<Integer> nodo4b = new NodoBinario<>(4, nodoMenos2, nodoMenos5);
            NodoBinario<Integer> raizFalsa = new NodoBinario<>(9, nodo2, nodo4b);
            ArbolBinario<Integer> arbolFalso = new ArbolBinario<>(raizFalsa);

            boolean resultadoFalso = ArbolUtil.mismosNegativos(arbolFalso);
            System.out.println("Resultado: " + resultadoFalso);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}