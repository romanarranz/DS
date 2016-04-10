#ifndef NODE_H
#define NODE_H

class Node
{
	public:
		int value;
		Node * prev, * next;

		Node(int i);
		~Node();
};

#endif
