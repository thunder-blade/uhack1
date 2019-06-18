import org.apache.tinkerpop.gremlin.orientdb.OrientGraph;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.T;
import org.apache.tinkerpop.gremlin.structure.Vertex;

public class App {
    public static void main(String[] args) {
        Graph graph = OrientGraph.open("remote:localhost/TestDB", "root", "rootpwd");
        graph.tx().open();
        Vertex marko = graph.addVertex(T.label, "person", "name", "marko", "age", 29);
        Vertex vadas = graph.addVertex(T.label, "person", "name", "vadas", "age", 27);
        Vertex lop = graph.addVertex(T.label, "software", "name", "lop", "lang", "java");
        Vertex josh = graph.addVertex(T.label, "person",  "name", "josh", "age", 32);
        Vertex ripple = graph.addVertex(T.label, "software",  "name", "ripple", "lang", "java");
        Vertex peter = graph.addVertex(T.label, "person",   "name", "peter", "age", 35);
        marko.addEdge("knows", vadas,   "weight", 0.5f);
        marko.addEdge("knows", josh,   "weight", 1.0f);
        marko.addEdge("created", lop,   "weight", 0.4f);
        josh.addEdge("created", ripple,   "weight", 1.0f);
        josh.addEdge("created", lop,   "weight", 0.4f);
        peter.addEdge("created", lop,   "weight", 0.2f);
    }
}
