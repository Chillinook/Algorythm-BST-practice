import java.util.ArrayList;
import java.util.List;

//import BinaryTree.Node;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> implements SearchTreeI<E> {
	
	
	protected boolean addReturn;
	protected E deleteReturn;


	public BinarySearchTree() {
		super(0);
	}
	public BinarySearchTree(E item) {
		super(0);
		
		add(item);
	}
	public BinarySearchTree(ArrayList<E> data) {
		super(0);
		//Todo		
		//please complete this method........

		for (E i : data)
		{
			add(i);
		}
		
		
	}
	
	
	@Override
	public E find(E target) {
		// TODO Auto-generated method stub
		return find(root, target);
	}
	@Override
	public boolean contains(E item) {
		// TODO Auto-generated method stub
		return find(item)!=null;	
	}

	private E find(Node<E> cRoot, E target)
	{
		if(cRoot==null) return null;
		
		int result = target.compareTo(cRoot.data);
		if(result==0) {
			return cRoot.data;
		}
		else if(result<0) 
		{
			return find(cRoot.left, target);
		}
		else{
			return find(cRoot.right, target);
		}
	}
	
	@Override
	public boolean add(E item) {
		// TODO Auto-generated method stub
		root=add(root, item);
			return addReturn;
	}
	protected Node<E> add(Node<E> cRoot, E item)
	{
		if(cRoot==null) {
			addReturn=true;
			return new Node<>(item);
		}
		int result = item.compareTo(cRoot.data);
		if(result<0) 
		{
			cRoot.left=add(cRoot.left, item);
		}
		else if(result>0){
			cRoot.right=add(cRoot.right, item);
		}
		else
		{
			addReturn=false;
		}
		return cRoot;	
	}
	
	

	@Override
	public E delete(E target) {
		// TODO Auto-generated method stub
		root = delete(root, target);
		return deleteReturn;
	}

	
	    private Node<E> delete(Node<E> cRoot, E item) {
	        if (cRoot == null) {
	            // item is not in the tree.
	            deleteReturn = null;
	            return cRoot;
	        }

	        // Search for item to delete.
	        int result = item.compareTo(cRoot.data);
	        if (result < 0) {
	            // item is smaller than localRoot.data.
	            cRoot.left = delete(cRoot.left, item);
	            return cRoot;
	        } else if (result > 0) {
	            // item is larger than localRoot.data.
	            cRoot.right = delete(cRoot.right, item);
	            return cRoot;
	        } else {
	            // item is at local root.
	            deleteReturn = cRoot.data;
	            if (cRoot.left == null) {
	                // If there is no left child, return right child
	                // which can also be null.
	                return cRoot.right;
	            } else if (cRoot.right == null) {
	                // If there is no right child, return left child.
	                return cRoot.left;
	            } else {
	                // Node being deleted has 2 children, replace the data
	                // with inorder predecessor.
	                if (cRoot.left.right == null) {
	                    // The left child has no right child.
	                    // Replace the data with the data in the
	                    // left child.
	                    cRoot.data = cRoot.left.data;
	                    // Replace the left child with its left child.
	                    cRoot.left = cRoot.left.left;
	                    return cRoot;
	                } else {
	                    // Search for the inorder predecessor (ip) and
	                    // replace deleted node's data with ip.
	                    cRoot.data = getLargestChildDeleteNode(cRoot.left);
	                    return cRoot;
	                }
	            }
	        }
	    }
	    
	    private E getLargestChildDeleteNode(Node<E> cRoot) {

	        if (cRoot.right.right == null) {
	            E returnValue = cRoot.right.data;
	            cRoot.right = cRoot.right.left;
	            return returnValue;
	        } else {
	            return getLargestChildDeleteNode(cRoot.right);
	        }
	    }
	    
	    @Override
	    public boolean remove(E target) {
	    	// TODO Auto-generated method stub
	        return delete(target) != null;
	    }
	    
	    @Override
	    public String toString()
	    {
	    	
	    	
	    	//Todo
			
			//please complete this method......	public static void inOrderTraversal(Node r)
	    	String Ans=inOrderTraversal(root);				
	    	return Ans.substring(0, Ans.length()-1);
	  
	    }
	    	
	    
//	    String BigList= new String();
//		private E findLength(Node<E> cRoot, int len)
//		{
//			
//			
//			if(cRoot==null) return null;
//			
////			int result = Integer.compare(4,cRoot.data.toString().length());  
//			int result = Integer.compare(5,5); 
//			
//			//lenResult = Integer.compare(len,root.data.toString().length());
//			if(result==0) {
//				BigList.add(cRoot.data);
//				return cRoot.data;
//			}
//			else if(result<0) 
//			{
//				return findLength(cRoot.left, len);
//			}
//			else{
//				return findLength(cRoot.right, len);
//			}
//		}
		
//		protected String lenCompare(Node<E> cRoot,int len)
//		{
//			if(cRoot==null) return "";			
//			
//			if( (Integer.compare(len,cRoot.data.toString().length())  == 0 ))
//			{
//				BigList += cRoot.data+" ";
//				
//			}
//			 
//			return inOrderTraversal(cRoot.left) +cRoot.data+" "+inOrderTraversal(cRoot.right);
//		}
//		
//	    
		   
	    
	    public BinarySearchTree<E> getSubBST(int len) {
	    	
	    	//Todo
			//please complete this method........
			//correct the return statement
	 	
	    	
//	    	ArrayList<E>AnsList= new ArrayList<E>();
//	    	
//	    	BinarySearchTree<E> mySubBST=new BinarySearchTree<E>();
//	    	
//	    	int lenResult;
//	    	String dataResult="";
//	    	

	    	
	    	BinarySearchTree<E> AnsTree=new BinarySearchTree<E>();	
	    	

	    	
	    	
	    	return AnsTree;
	    }
		
		public String showValuesInRange(E start, E end)
		{
			//Todo
			
			//please complete this method........
//			find(start);
			
			return find(start).toString();
		}
		
		public String findLargestValue()
		{

			//Todo
			
			//please complete this method........		
			
			Node Ans = root;
			
			while( Ans.right != null)
			{
				Ans = Ans.right;
			}					
			return Ans.toString();
		}
		
		public String findLowestValue()
		{

			//Todo
			
			//please complete this method........
			Node Ans = root;
			while( Ans.left != null)
			{
				Ans = Ans.left;
			}					
			return Ans.toString();
		
		}
}