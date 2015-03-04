using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace AlgorithmStudy
{
    class CircularQueue
    {
        private int[] queue;
        private int queueSize;
        private int head;
        private int tail;

        const int EXIT_CODE = -1;
        const int DEQUEUE_CODE = 0;

        public CircularQueue( int queueSize )
        {
            init( queueSize );
        }

        /// <summary>
        /// Circular Queue Initialization
        /// </summary>
        /// <param name="queueSize">Array Size</param>
        private void init( int queueSize )
        {
            head = -1;
            tail = -1;
            this.queueSize = queueSize;

            queue = new int[queueSize];
        }

        public QueueType call(int value)
        {
            if ( value == EXIT_CODE )
            {
                Console.WriteLine("Bye");

                return QueueType.EXIT;
            }
            else if (value == DEQUEUE_CODE)
            {
                return output();
            }
            else
            {
                return input(value);
            }
        }

        /// <summary>
        /// enqueue
        /// </summary>
        /// <param name="value"></param>
        private QueueType input(int value)
        {
            if (isQueueFull())
            {
                Console.WriteLine("Queue is Full");

                return QueueType.ENQUEUE_FAIL_SIZEFULL;
            }
            else
            {
                if (tail == queueSize - 1)
                {
                    tail = 0;
                }
                else
                {
                    tail++;
                }

                queue[tail] = value;

                if (head == -1)
                {
                    head = 0;
                }

                Console.WriteLine("Queue In {0}", value);

                return QueueType.ENQUEUE;
            }
        }

        /// <summary>
        /// dequeue
        /// </summary>
        private QueueType output()
        {
            if (isQueueEmpty())
            {
                Console.WriteLine("Queue is Empty");

                return QueueType.DEQUEUE_FAIL_SIZEEMPTY;
            }
            else
            {
                int value;
                value = queue[head];
                queue[head] = 0;

                if (head == tail)
                {
                    head = tail = -1;
                }
                else
                {
                    if (head == queueSize - 1)
                    {
                        head = 0;
                    }
                    else
                    {
                        head++;
                    }
                }

                Console.WriteLine("Queue Out {0}", value);

                return QueueType.DEQUEUE;
            }
        }
        
        /// <summary>
        /// is Saved Queue Full?
        /// </summary>
        /// <returns></returns>
        private bool isQueueFull()
        {
            return ((head == 0 && tail == queueSize - 1) || (tail + 1 == head));
        }

        /// <summary>
        /// is Saved Queue Empty?
        /// </summary>
        /// <returns></returns>
        private bool isQueueEmpty()
        {
            return head == -1;
        }
    }

    enum QueueType
    {
        ENQUEUE,
        ENQUEUE_FAIL_SIZEFULL,

        DEQUEUE,
        DEQUEUE_FAIL_SIZEEMPTY,

        EXIT
    }
}
