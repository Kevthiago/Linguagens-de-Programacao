import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    //Atributos
    private int IdPedido;
    private Date dataPedido;
    private String statusPedido; //pendente, processando, enviado, entregue;
    private double valorTotal;
    private List<Pedido> itensPedido = new ArrayList<>();
    private Usuario usuario;

}
