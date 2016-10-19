package ServletHelp;

public class GrindTable {

	private static int[][] magicSquare;
	public static String returnMagicSquare(int size) {
		int n = size;
		String content = "";
		if (n % 2 == 0) {
			//throw new RuntimeException("n must be odd");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////			
	    	System.out.println("this is even condition");
			int magicSquare[][] = new int[n][n];    
	    	int countUpNumber = 1;     
	    	StringBuilder usedNumbers = new StringBuilder();     
	    	int miniSquareNumber = n/4;      
	    	for (int j=0;j < magicSquare.length;j++)     {       
	    		//populate the corner mini-squares       
	    		if ((j < miniSquareNumber) || (j > magicSquare.length-1-miniSquareNumber))       {         
	    			for (int k=0;k < miniSquareNumber;k++)          {           
	    				magicSquare[j][k] = countUpNumber;           
	    				usedNumbers.append("/"+countUpNumber+"/");           
	    				countUpNumber++;         
	    			}         
	    			countUpNumber = countUpNumber+(miniSquareNumber+miniSquareNumber);         
	    			for (int k=magicSquare.length-miniSquareNumber;k < magicSquare.length;k++)         {           
	    				magicSquare[j][k] = countUpNumber;           
	    				usedNumbers.append("/"+countUpNumber+"/");           
	    				countUpNumber++;         
	    			}       
	    		}       
	    		else {//populate the large center square       {         
	    			countUpNumber = countUpNumber+miniSquareNumber;         
	    			for (int k=miniSquareNumber;k < magicSquare.length-miniSquareNumber;k++)         {            
	    				magicSquare[j][k] = countUpNumber;           
	    				usedNumbers.append("/"+countUpNumber+"/");           
	    				countUpNumber++;         
	    			}         
	    			countUpNumber = countUpNumber+miniSquareNumber;       
	    		}    
	    	}      
	    	int countDownNumber = n*n - miniSquareNumber;     
	    	//populate remaining squares     

	    	for (int l=0;l < magicSquare.length;l++)     {       
	    		for (int m=0;m < magicSquare[l].length;m++)       {         
	    			
		    		if (magicSquare[l][m] == 0)         {           
		    			while (usedNumbers.indexOf("/"+countDownNumber+"/") != -1){             
		    				countDownNumber--;           
		    			}
		    			magicSquare[l][m] = countDownNumber;
		    			countDownNumber--;
		    		}
		    	}
		    }
	    	int magicConstant = 0;     
			for (int j=0;j < magicSquare.length;j++)     {       
				content += "<tr>";
				for (int k = 0; k < magicSquare[j].length; k++) { 
					content += "<td class=\"cell\">" + magicSquare[j][k] + "</td>";
				}
				content += "</tr>";
				
				magicConstant = magicConstant + magicSquare[j][0];
			}
			System.out.println("end of even condition");
			return content;	
		}	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		 else {
			int[][] magic = new int[n][n];

			int row = n - 1;
			int col = n / 2;
			magic[row][col] = 1;

			for (int i = 2; i <= n * n; i++) {
				if (magic[(row + 1) % n][(col + 1) % n] == 0) {
					row = (row + 1) % n;
					col = (col + 1) % n;
				} else { row = (row - 1 + n) % n;}
				magic[row][col] = i;
			}

			// print results
			for (int i = 0; i < n; i++) {
				content += "<tr>";
				for (int j = 0; j < n; j++) { content += "<td class=\"cell\">" + magic[i][j] + "</td>";}
				content += "</tr>";
			}
		}
		return content;
	}
}