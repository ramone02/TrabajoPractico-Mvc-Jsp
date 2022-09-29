package app.models;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CuentaBancaria implements Serializable {

    public CuentaBancaria() {
    }

    private Integer id;
    private double saldo;
    private List<String> movimientos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<String> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<String> movimientos) {
        this.movimientos = movimientos;
    }

    public static List<CuentaBancaria> getCuentas() {
        List<CuentaBancaria> cuentas = new LinkedList<>();
        CuentaBancaria cuenta1 = new CuentaBancaria();
        cuenta1.setId(001);
        cuenta1.setSaldo(20000);
        cuentas.add(cuenta1);

        CuentaBancaria cuenta2 = new CuentaBancaria();
        cuenta2.setId(002);
        cuenta2.setSaldo(30000);
        cuentas.add(cuenta2);

        CuentaBancaria cuenta3 = new CuentaBancaria();
        cuenta3.setId(003);
        cuenta3.setSaldo(105000);
        cuentas.add(cuenta3);
        return cuentas;
    }

    public void validar(Map<String, String[]> parametros) {
        List<CuentaBancaria> cuentas = CuentaBancaria.getCuentas();
        List<String> errores = new LinkedList<>();
        String patternNum = "[\\d]+";
        Integer idOrigen = Integer.parseInt(parametros.get("origen")[0]);
        Integer idDestino = Integer.parseInt(parametros.get("destino")[0]);
        Double monto = Double.parseDouble(parametros.get("monto")[0]);

        if (parametros.get("origen")[0].isEmpty()) {
            errores.add("El campo Cuenta Origen esta vacio");
        } else if (idOrigen.equals(idDestino) ) {
            errores.add("La transferencia no se puede enviar a la misma cuenta de origen");
        }
        
//        if(){
//            
//        }
        
        if(errores.size() > 0){
            // Throw ExceptionPersonalizada(errores);
        } else {
            //if(cuenta.getSaldo() >= monto){
                  //  cuenta.setSaldo(cuenta.getSaldo() - monto);
                //}
           return;
        }

    }

    public void transferir(Integer idOrigen, Integer idDestino, double monto) {
        List<CuentaBancaria> cuentas = CuentaBancaria.getCuentas();
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getId().equals(idOrigen)) {
                if(cuenta.getSaldo() >= monto){
                    cuenta.setSaldo(cuenta.getSaldo() - monto);
                }                
            } else if (cuenta.getId().equals(idDestino)) {
                cuenta.setSaldo(cuenta.getSaldo() + monto);
            }
        }
    }
}
