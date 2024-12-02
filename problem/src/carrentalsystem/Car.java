package carrentalsystem;


public class Car {
    private String modelName;
    private String reg_no;

    private boolean isBooked;

    public Car(String modelName, String reg_no) {
        this.modelName = modelName;
        this.reg_no = reg_no;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }
}
