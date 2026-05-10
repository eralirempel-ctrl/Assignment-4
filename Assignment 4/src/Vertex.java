public class Vertex {
    private int id; // Уникальный идентификатор [cite: 17]

    public Vertex(int id) { this.id = id; } // Конструктор [cite: 19]
    public int getId() { return id; } // Геттер [cite: 20]
    @Override
    public String toString() { return "V" + id; } // [cite: 21]
}