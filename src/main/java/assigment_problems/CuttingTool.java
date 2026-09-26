public class CuttingTool extends GardenTool {

    @Override
    public String use() {
        return "Using the tool in the garden, blade sharpened first";
    }

    public static void main(String[] args) {
        CuttingTool c = new CuttingTool();
        Pruner p = new Pruner();

        System.out.println(c.use());
        System.out.println(p.use());
    }
}