public class Test implements Comparable<Test>
{
    public int data;

    public Test(int data)
    {
        this.data = data;
    }

    @Override
    public String toString()
    {
        return data + "";
    }

    @Override
    public int compareTo(Test test)
    {
        return data - test.data;
    }

    @Override
    public boolean equals(Object obj)
    {
        boolean isEqual = false;
        if (this.getClass() == obj.getClass())
        {
            Test test = (Test) obj;
            if (test.data == this.data) {
                isEqual = true;
            }
        }
        return isEqual;
    }
}
