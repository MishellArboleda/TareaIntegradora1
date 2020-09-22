package model;

import java.util.Comparator;

public class ClientComparator implements Comparator<Client> {

    @Override
    public int compare(Client client1, Client client2) {
        int comparator;
        String last_name1 = client1.getLast_name();
        String last_name2 = client2.getLast_name();
        String name1 = client1.getName();
        String name2 = client2.getName();

        if (last_name1.compareTo(last_name2) < 0) {
            comparator = -1; // Cliente 1 es antes
        }else if(last_name1.compareTo(last_name2)>0) {
            comparator = 1; // Cliente 1 es despues
        }else {
            if(name1.compareTo(name2)<0) {
                comparator = -1; //client1 es antes
            }else if(name1.compareTo(name2)>0) {
                comparator = 1; //client1 es despues
            }else {
                comparator = 0; // clientes son inguales
            }
        }
        return comparator;
    }




}