package app.models;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

public class CuentaBancaria implements Serializable {

    public CuentaBancaria() {
    }

    public static List<CuentaBancaria> cuentas = new LinkedList<>();
    private LinkedList<String> errores = new LinkedList<>();
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

    public List<String> getErrores() {
        return this.errores;
    }

    public List<String> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<String> movimientos) {
        this.movimientos = movimientos;
    }

    //Lista de CuentaBancaria instanciadas, para poder trabajar la persistencia
    public static List<CuentaBancaria> setCuentas() {

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
    
    //devolver el saldo segun el Id
    public double getSaldoById(Integer idCuenta){
        double saldo = 0;
        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getId().equals(idCuenta)) {
                saldo = cuenta.getSaldo();
                break;
            }
        }
        return saldo;
    }   

    public static List<CuentaBancaria> getCuentas() {
        return cuentas;
    }

    public void transferir(Map<String, String[]> parametros) throws FormException {
        List<CuentaBancaria> cuentas = CuentaBancaria.getCuentas();
        String patternNum = "[\\d]+";

        //Verifico que los campos no vengan vacios
        if (parametros.get("origen")[0].isEmpty()) {
            this.errores.add("El campo Cuenta Origen esta vacio");
        } else if (!Pattern.matches(patternNum, parametros.get("origen")[0])) {
            this.errores.add("El campo Cuenta Origen no es numero");
        }

        if (parametros.get("destino")[0].isEmpty()) {
            this.errores.add("El campo Cuenta Destino esta vacio");
        } else if (!Pattern.matches(patternNum, parametros.get("destino")[0])) {
            this.errores.add("El campo Cuenta Destino no es numero");
        }

        //Si encuentro algun error, lanzo la excepcion para no seguir ejecutando "transferir"
        if (errores.size() > 0) {
            throw new FormException("Se han encontrado Errores");
        }

        //Si no encuentro errores de campo vacio parseo los valores del form para manejarlos mas comodo
        Integer idOrigen = Integer.parseInt(parametros.get("origen")[0]);
        Integer idDestino = Integer.parseInt(parametros.get("destino")[0]);
        Double monto = Double.parseDouble(parametros.get("monto")[0]);

        if (idOrigen.equals(idDestino)) {
            this.errores.add("La transferencia no se puede enviar a la misma cuenta de origen");
        }

        if (monto <= 0) {
            this.errores.add("El monto a transferir debe ser mayor a 0");
        }

        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getId().equals(idOrigen)) {
                if (cuenta.getSaldo() >= monto) {
                    cuenta.setSaldo(cuenta.getSaldo() - monto);
                } else {
                    this.errores.add("El monto que desea transferir es mayor a su saldo");
                }
            }
        }

        if (errores.size() > 0) {
            throw new FormException("Se han encontrado Errores");
        }

        for (CuentaBancaria cuenta : cuentas) {
            if (cuenta.getId().equals(idDestino)) {
                cuenta.setSaldo(cuenta.getSaldo() + monto);
            }
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CuentaBancaria other = (CuentaBancaria) obj;
        return Objects.equals(this.id, other.id);
    }
}
