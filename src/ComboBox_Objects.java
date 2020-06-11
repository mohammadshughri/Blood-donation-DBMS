
public class ComboBox_Objects {
	
	private String key;
    private String value;

    public ComboBox_Objects(String key)
    {
        this.key = key;
       
    }

    @Override
    public String toString()
    {
        return key; 
    }

    public String getKey()
    {
        return key;
    }

//    public String getValue()
//    {
//        return value;
//    }

}
