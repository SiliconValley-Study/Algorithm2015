using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;


namespace AlgorithmStudy
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Input Your Circular Queue Array Size : ");
            int length = Convert.ToInt32(Console.ReadLine());

            CircularQueue cQueue = new CircularQueue(length);

            Console.WriteLine("Input Your Value[{0},{1},{2}]", " -1:exit ", " 0:dequeue ", " any:enqueue ");
            QueueType queueType;
            do
            {
                int number = Convert.ToInt32(Console.ReadLine().Trim());

                queueType = cQueue.call(number);
            } while (queueType != QueueType.EXIT);
        }
    }
}
