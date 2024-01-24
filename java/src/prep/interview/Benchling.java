package prep.interview;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Benchling {
	public void findMatch(String genome, List<String> guide, int max_diff)
	{
		for(String g : guide)
		{
			if(g.length()==genome.length())
			{
				int diff=0;
				int ptr=0;
				while(ptr<genome.length() && diff<max_diff)
				{
					if(g.indexOf(genome.charAt(ptr++))==-1)
						diff++;
					
				}
				if(diff<max_diff)
					System.out.println(g+" : true");
				else
					System.out.println(g+" : false");
				
			}
			else
				System.out.println(g+" : false");
		}
	}
	
	public String countOccurences(String strand)
	{
		HashMap<Character, Integer> counts = new HashMap<Character, Integer>();
		PriorityQueue<Character> order = new PriorityQueue<Character>(); 
		
		for(char c : strand.toCharArray())
			counts.put(c, counts.getOrDefault(c, 0)+1);
		
		for(Map.Entry<Character, Integer> entry : counts.entrySet())
			order.add(entry.getKey());

		StringBuffer sb = new StringBuffer();
		for(Map.Entry<Character, Integer> entry : counts.entrySet())
		{
			char key = order.poll();
			sb.append(counts.get(key)+" ");
		}
		
		return sb.toString();
	}
	
	public String complementDna(String dna)
	{
		StringBuffer res = new StringBuffer();
		HashMap<Character, Character> comp = new HashMap<Character, Character>();
		comp.put('A', 'T');
		comp.put('T', 'A');
		comp.put('G', 'C');
		comp.put('C', 'G');
		
		for(char c : dna.toCharArray())
			res.append(comp.get(c));		
		
		return res.reverse().toString();
	}
	
	public String highestGCContent(List<String> gcStrand)
	{
		StringBuffer sb = new StringBuffer();
		float maxGc = Float.MIN_VALUE;
		String maxGcName = "";
		
		for(String strand : gcStrand)
		{
			String strName = strand.split(" ")[0];
			String str = strand.split(" ")[1];
			int gcCount = 0;
			for(char c : str.toCharArray())
				if(c=='G'||c=='C')
					gcCount++;
			float gcContent = 100*((float)gcCount/(float)strand.length());
			System.out.println("gcContent : "+gcContent);
			if(gcContent>maxGc)
			{
				maxGc = gcContent;
				maxGcName = strName;
			}
		}
		return maxGcName+" "+maxGc;
	}
	
	public void findLocationofSubstring(String s, String t)
	{
		int index=s.indexOf(t);
		while(index!=-1)
		{
			System.out.print(index+1+" ");
            index = s.indexOf(t, index + 1);
		}
	}
	
	public void consensusAndProfile(char[][] dna)
	{
		int cols = dna[0].length;
		int[][] profile = new int[4][cols];
		
		for(int i=0;i<dna.length;i++)
		{
			for(int j=0;j<cols;j++)
			{
				switch(dna[i][j])
				{
					case 'A':
						profile[0][j]++;
						break;
					case 'C':
						profile[1][j]++;
						break;
					case 'G':
						profile[2][j]++;
						break;
					case 'T':
						profile[3][j]++;
						break;
					
				}
			}
		}
		
		for(int i=0;i<profile.length;i++)
		{
			for(int j=0;j<cols;j++)
			{
				System.out.print(" "+profile[i][j]+" ");
			}
			System.out.println();
		}
		
		StringBuffer consensus = new StringBuffer();
		
		for(int i=0;i<profile[0].length;i++)
		{
			int maxCount = Integer.MIN_VALUE;
			char con_char = 0;
			for(int j=0;j<profile.length;j++)
			{
//				maxCount=Math.max(maxCount, profile[j][i]);
				if(profile[j][i]>maxCount)
				{
					maxCount=profile[j][i];
					switch(j)
					{
						case 0 : con_char='A'; break;
						case 1 : con_char='C'; break;
						case 2 : con_char='G'; break;
						case 3 : con_char='T'; break;
					}
				}
					
			}
			consensus.append(con_char);
		}
		
		for(char c : consensus.toString().toCharArray())
			System.out.print(" "+c+" ");
				
		
		
	}
	
	public void parseTagsText(String text)
	{
		// Create a Pattern object
        Pattern pattern = Pattern.compile("<h1>(.+)</h1>");

        // Create a Matcher object
        Matcher matcher = pattern.matcher(text);

        // Find the first match
        if (matcher.find()) {
            // Get the matched text
            String matchedText = matcher.group(1);

            // Print the matched text
            System.out.println(matchedText);
        }
	}

	public static void main(String[] args) {
		Benchling b = new Benchling();
//		b.findMatch("AAACC", Arrays.asList("CCAGG","GGGAA","AACCG"), 2);
		
//		System.out.println(b.countOccurences("AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC"));

//		System.out.println(b.complementDna("AAAACCCGGT"));
		
//		List<String> contentMap = new ArrayList<String>();
//		contentMap.add(">Rosalind_6404 CCTGCGGAAGATCGGCACTAGAATAGCCAGAACCGTTTCTCTGAGGCTTCCGGCCTTCCCTCCCACTAATAATTCTGAGG");
//		contentMap.add(">Rosalind_5959 CCATCGGTAGCGCATCCTTAGTCCAATTAAGTCCCTATCCAGGCGCTCCGCCGAAGGTCTATATCCATTTGTCAGCAGACACGC");
//		contentMap.add(">Rosalind_0808 CCACCCTCGTGGTATGGCTAGGCATTCAGGAACCGGAGAACGCTTCAGACCAGCCCGGACTGGGAACCTGCGGGCAGTAGGTGGAAT");
//		System.out.println(b.highestGCContent(contentMap));
		
//		b.findLocationofSubstring("GATATATGCATATACTT", "ATAT");
		
//		b.consensusAndProfile(new char[][] {{'A','T','C','C','A','G','C','T'},
//											{'G','G','G','C','A','A','C','T'},
//											{'A','T','G','G','A','T','C','T'},
//											{'A','A','G','C','A','A','C','C'},
//											{'T','T','G','G','A','A','C','T'},
//											{'A','T','G','C','C','A','T','T'},
//											{'A','T','G','G','C','A','C','T'}});
	
		b.parseTagsText("<h1>This is a heading</h1>");
	}

}
