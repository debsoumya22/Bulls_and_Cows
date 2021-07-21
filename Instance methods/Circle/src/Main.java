class Circle {

    double radius;

    public double getLength() {
        return Math.PI * 2 * this.radius;
    }
    
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }
}
