import org.apache.storm.Config;
import org.apache.storm.StormSubmitter;
import org.apache.storm.topology.TopologyBuilder;


public class TopologyMain {
    public static void main(String[] args) throws Exception {

        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("Spout", new Spout());
        builder.setBolt("Bolt", new Bolt()).shuffleGrouping("Spout");

        Config conf = new Config();
        conf.setDebug(true);

        StormSubmitter.submitTopology("Topology", conf, builder.createTopology());

}}
