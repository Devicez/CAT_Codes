package com.company;

import java.util.*;

public class Main
{
    public ArrayList<String> InputCAT_Codes()
    {
        int codeAmount = 0;
        int codeLength = 0;
        ArrayList<String> code = new ArrayList<String>();

        Scanner input = new Scanner(System.in);

        try
        {
            codeAmount = input.nextInt();
            codeLength = input.nextInt();

            if(codeAmount < 5 || codeAmount > 100000)
            {
                throw new InputMismatchException("[Amount out of bound]\n");
            }
            if(codeLength < 5 || codeLength > 30)
            {
                throw new InputMismatchException("[Length out of bound]\n");
            }

            for(int i = 0; i< codeAmount; i++)
            {
                Scanner input2 = new Scanner(System.in);
                String buf = input2.nextLine();

                if(buf.length() > codeLength || buf.length() < codeLength)
                {
                    throw new InputMismatchException("[Code codeLength out of bound]\n");
                }

                for(int j = 0; j< codeLength; j++)
                {
                    if(buf.charAt(j) != '0' && buf.charAt(j) != '1')
                    {
                        throw new InputMismatchException("[Input Contains Other value than 0 or 1]\n");
                    }
                }
                code.add(buf);
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println(e);
            System.exit(0);
        }

        return code;
    }

    //===============================================================//

    public ArrayList<String> InputFile()
    {
        int fileAmount = 0;
        int fileLength = 0;
        ArrayList<String> fileCode = new ArrayList<String>();

        Scanner input = new Scanner(System.in);

        try
        {
            fileAmount = input.nextInt();
            if(fileAmount < 1 || fileAmount > 100)
            {
                throw new InputMismatchException("[File amount out of bound]");
            }

            for (int i=0;i<fileAmount;i++)
            {
                Scanner input2 = new Scanner(System.in);
                fileLength = input2.nextInt();

                if(fileLength < 1 || fileLength > 1000000)
                {
                    throw new InputMismatchException();
                }

                Scanner input3 = new Scanner(System.in);
                String code = input3.nextLine();

                if(code.length() != fileLength)
                {
                    throw new InputMismatchException();
                }

                for(int j = 0; j< fileLength; j++)
                {
                    if(code.charAt(j) != '0' && code.charAt(j) != '1')
                    {
                        throw new InputMismatchException("[Input Contains Other value than 0 or 1]\n");
                    }
                }
                fileCode.add(code);
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println(e);
            System.exit(0);
        }

        return fileCode;
    }

    //===============================================================//

    public void checkCode(ArrayList<String> CAT_Codes,ArrayList<String> fileCodes)
    {
        int length = CAT_Codes.get(0).length();

        for(int i=0;i<fileCodes.size();i++)
        {
            boolean ok  = true;
            ArrayList<Integer> codeFound = new ArrayList<Integer>();

            String code = fileCodes.get(i);
            for(int j=length;j<=code.length();j++)
            {
                for(int k=0;k<CAT_Codes.size();k++)
                {
                    if(CAT_Codes.get(k).equals(code.substring(j-length,j)))
                    {
                        ok = false;
                        codeFound.add(k+1);

                    }
                }
            }

            Collections.sort(codeFound);

            if(ok)
            {
                System.out.println("OK");
            }
            else
            {
                for (Integer l:codeFound)
                {
                    System.out.print(l + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args)
    {
        Main m = new Main();

        ArrayList<String> CAT_Codes = new ArrayList<String>(m.InputCAT_Codes());
        ArrayList<String> fileCodes = new ArrayList<String>(m.InputFile());

        m.checkCode(CAT_Codes,fileCodes);
    }
}