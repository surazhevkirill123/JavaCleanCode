package entity;

import collection.ClassificationLevel;
import collection.ExperimentalType;

public class ExperimentalPlane extends Plane{
    private ExperimentalType type;
    private ClassificationLevel classificationLevel;


    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalType type, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel(){
        return classificationLevel;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel){
        this.classificationLevel = classificationLevel;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return "ExperimentalPlane{" + "type=" + type +
                ", classificationLevel=" + classificationLevel +
                ", model='" + model + '\'' +
                '}';
    }
}
