package hcm.moz.impl.constants;

public enum DHIS2FormEnums {

    COMMUNITY_WAREHOUSE_ENTRY("AC (Armazem Comunitarial) - Entradas"),
    COMMUNITY_WAREHOUSE_EXIT("AC (Armazem Comunitarial) - Saidas"),
    COMMUNITY_WAREHOUSE_PHYSICAL_COUNT("AC (Armazem Comunitarial) - Contagem física"),
    DISTRICT_WAREHOUSE_ENTRY("AD (Armazém distrital) - Entradas"),
    DISTRICT_WAREHOUSE_EXIT ("AD (Armazém distrital) - Saidas"),
    DISTRICT_WAREHOUSE_PHYSICAL_COUNT ("AD (Armazém distrital)- Contagem física");

    private final String name;

    DHIS2FormEnums(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


}
