package abbaco.presentation.dtoModels;

public class CashFlowClassifierDto {
    private String id;
    private int code;
    private String name;

    public CashFlowClassifierDto(){}

    public CashFlowClassifierDto(String id, int code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}