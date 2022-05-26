# Втора лабораториска вежба по Софтверско инженерство
### Филип Ѓорѓиевски, бр. на индекс 192011
#### Control Flow Graph
![cfg](https://user-images.githubusercontent.com/62121417/170577462-a4b98d9f-a212-490e-b97e-19857a14bb68.png)
#### Цикломатска комплексност
Цикломатската комплексност на овој код е 11 , истата ја добив преку формулата P+1 каде P e бројот на предикатни јазли во графот т.е. јазли кои што се разгрануваат како што е if. 10 предикатни јазли + 1 = 11.
#### Тест случаи според критериумот Every statement
        @Test
        void everyStatementTest() {
        // list.size = 0 for first exception
        List<String> EmptyList = Collections.emptyList();

        IllegalArgumentException ex;
        ex = assertThrows(IllegalArgumentException.class, () -> SILab2.function(EmptyList));
        assertTrue(ex.getMessage().contains("List length should be greater than 0"));

        // list.size = 3 for second exception
       List<String> listOfThree = new ArrayList<String>();
       listOfThree.add("0");
       listOfThree.add("#");
       listOfThree.add("0");
        ex = assertThrows(IllegalArgumentException.class, () -> SILab2.function(listOfThree));
        assertTrue(ex.getMessage().contains("List length should be a perfect square"));

        // valid input of list for all another statements
        List<String> trueList = new ArrayList<String>();
        trueList.add("1");
        trueList.add("#");
        trueList.add("2");
        trueList.add("0");
        trueList.add("3");
        trueList.add("#");
        trueList.add("1");
        trueList.add("#");
        trueList.add("#");

        // result list to compare if everything is okay with function, here exceptions won't be executed
        List<String> inputList = new ArrayList<String>();
        inputList.add("0");
        inputList.add("#");
        inputList.add("0");
        inputList.add("0");
        inputList.add("0");
        inputList.add("#");
        inputList.add("0");
        inputList.add("#");
        inputList.add("#");

        assertEquals(trueList, SILab2.function(inputList));
    }
#### Тест случаи според критериумот Every path
        @Test
        void testEveryPath(){
        // 1 -> 2 -> 34
        List<String> EmptyList = Collections.emptyList();
        IllegalArgumentException ex;
        ex = assertThrows(IllegalArgumentException.class, () -> SILab2.function(EmptyList));
        assertTrue(ex.getMessage().contains("List length should be greater than 0"));
        // 1 -> 3 -> 4,5,6 -> 7 -> 34
        List<String> listOfThree = new ArrayList<String>();
        listOfThree.add("0");
        listOfThree.add("#");
        listOfThree.add("0");
        listOfThree.add("0");
        listOfThree.add("0");
        ex = assertThrows(IllegalArgumentException.class, () -> SILab2.function(listOfThree));
        assertTrue(ex.getMessage().contains("List length should be a perfect square"));

        // 1 -> 3 -> 4,5,6 -> 8,9 -> 10.1 -> 10.2 -> 32 -> 33 -> 34 - can't happen
        // 1 -> 3 -> 4,5,6 -> 8,9 -> 10.1 -> 10.2 -> 11 -> 28 -> 29 -> 30,31 -> 32 -> 33 -> 34
        // valid input of list for all another statements
        List<String> trueList = new ArrayList<String>();
        trueList.add("#");
        trueList.add("#");
        trueList.add("#");
        trueList.add("#");
        trueList.add("#");
        trueList.add("#");
        trueList.add("#");
        trueList.add("#");
        trueList.add("#");

        // result list to compare if everything is okay with function, here exceptions won't be executed
        List<String> inputList = new ArrayList<String>();
        inputList.add("#");
        inputList.add("#");
        inputList.add("#");
        inputList.add("#");
        inputList.add("#");
        inputList.add("#");
        inputList.add("#");
        inputList.add("#");
        inputList.add("#");
        assertEquals(trueList, SILab2.function(inputList));

        // 1 -> 3 -> 4,5,6 -> 8,9 -> 10.1 -> 10.2 -> 11 -> 12 -> 13 -> 14 -> 15 -> 16,17,18,19
        // valid input of list for all another statements
        trueList = new ArrayList<String>();
        trueList.add("1");
        trueList.add("#");
        trueList.add("2");
        trueList.add("0");
        trueList.add("3");
        trueList.add("#");
        trueList.add("1");
        trueList.add("#");
        trueList.add("#");

        // result list to compare if everything is okay with function, here exceptions won't be executed
        inputList = new ArrayList<String>();
        inputList.add("0");
        inputList.add("#");
        inputList.add("0");
        inputList.add("0");
        inputList.add("0");
        inputList.add("#");
        inputList.add("0");
        inputList.add("#");
        inputList.add("#");

        assertEquals(trueList, SILab2.function(inputList));
        // 1 -> 3 -> 4,5,6 -> 8,9 -> 10.1 -> 10.2 -> 11 -> 12 -> 13 -> 14 -> 16,17,18,19 -> 20 - same as test above because we
        // have list of 0#0 00# 0## and if we proceed for all values in that list we will pass all paths.

        // 1 -> 3 -> 4,5,6 -> 8,9 -> 10.1 -> 10.2 -> 11 -> 12 -> 13 -> 20 -> 21 -> 22 -> 23
        // 1 -> 3 -> 4,5,6 -> 8,9 -> 10.1 -> 10.2 -> 11 -> 12 -> 13 -> 20 -> 21 -> 23 -> 24 -> 25 -> 26
        // 1 -> 3 -> 4,5,6 -> 8,9 -> 10.1 -> 10.2 -> 11 -> 12 -> 13 -> 20 -> 21 -> 23 -> 24 -> 26 -> 27 -> 28 -> 29 -> 30,31 -> 32 -> 10.3 -> 10.2

    }


#### Објаснување на напишаните unit tests
Како што е објаснето и во кодот со помош на коментари, во every statement прво имам пратено празна листа за да биде извршен првиот exception, потоа за вторио exception каде што имам пратено листа со 5 елементи, додека на крајот за Every statement испратив исправна листа за да ги помине останатите statements.
Кај every path исто за првиот и вториот exception имам пратено соодветна листи каде што би се фрлил тој exception.
Додека за другите патеки кој што се оставени без тест мислам дека нема потреба затоа што со еден ист пример може да се поминат сите патеки поради тоа што имаме 0#0 00# 00## и за некоја од овие вредности пр. 0 ќе влезе во некоја од дадените патеки, па за # и така натаму се додека не заврши for циклусот т.е. додека не се излистаат сите елементи во листата.

