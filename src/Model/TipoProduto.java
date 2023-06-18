package Model;

public enum TipoProduto {
    //enumeração é uma constante, valores fixos que nunca sao alterados,
    //facilita na adição de produtos
    CD (1),
    Livro(2),
    Jornal(3),
    Revista(4);

    private int value;

    public int getValue() {
        return value;
    }

    TipoProduto(int i) {
        this.value = i;
    }
}

