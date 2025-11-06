// Given an array, 
// rotate the array to the right by k steps, 
// where k is non-negative.

int[] RotateArrayMethod1(int[] array, int k)
{
    int size = array.Length;
    if (size == k || size == 0) 
    {
        return array;
    }

    int counter = 1;
    for (int i = 0; i < size; i++)
    {
        if (counter <= k)
        {
            int lastItem = array[size - 1];
            Array.Resize(ref array, size);
            Array.Copy(array, 0, array, 1, size - 1);
            array[0] = lastItem;
            counter++;
        }
    }

    return array;
}

int[] array = [1, 2, 3, 4, 5];
int k = 3;

Console.WriteLine(string.Join(", ", RotateArrayMethod1(array, k)));