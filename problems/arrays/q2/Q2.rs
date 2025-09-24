struct RotatingStruct;

// Given an array, 
// rotate the array to the right by k steps, 
// where k is non-negative.

impl RotatingStruct {
    fn rotate_array_method1(arr: Vec<i32>, k: i32) -> Vec<i32> {
        let size = arr.len() as i32;
        let mut new_array = arr.clone();

        if size == k || size == 0 {
            return new_array;
        }

        let mut counter: i32 = 1;
        for _ in arr.iter() {
            if counter <= k {
                let last_item = new_array[new_array.len() - 1];
                new_array.pop();
                new_array.insert(0, last_item);
                counter += 1;
            }
        }

        new_array
    }
}

fn main() {
    let arr = vec![1, 2, 3, 4, 5];
    let k = 3;

    let output1 = RotatingStruct::rotate_array_method1(arr, k);

    println!("{:?}", output1);
}