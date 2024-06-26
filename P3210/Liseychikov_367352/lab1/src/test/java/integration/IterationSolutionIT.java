package integration;


import command.ConsoleCommand;
import lombok.SneakyThrows;
import model.Result;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IterationSolutionIT {
    @Test
    @SneakyThrows
    void computeSmallData() {
        String table = """
                №	|x1				|x2				|x3			|eps1		|eps2		|eps3		|
                1	|1,200000		|1,060000		|0,948000		| 1,200000	|1,060000	|0,948000	|
                2	|0,999200		|1,005360		|0,999088		| 0,200800	|0,054640	|0,051088	|
                3	|0,999555		|1,000180		|1,000053		| 0,000355	|0,005180	|0,000965	|
                4	|0,999977		|0,999999		|1,000005		| 0,000421	|0,000181	|0,000048	|
                5	|1,000000		|1,000000		|1,000000		| 0,000023	|0,000000	|0,000005	|
                6	|1,000000		|1,000000		|1,000000		| 0,000000	|0,000000	|0,000000	|
                """;
        String data = """
                3
                0.00001
                2 2 10 14
                10 1 1 12
                2 10 1 13
                """;
        ByteArrayInputStream testInput = new ByteArrayInputStream(data.getBytes("UTF-8"));
        System.setIn(testInput);

        Result result = new ConsoleCommand().execute();

        assertAll(
                () -> assertIterableEquals(List.of(1.0000000233388033, 0.9999999791052187, 0.9999999995111957), result.getResult()),
                () -> assertEquals(table, result.getTable())
        );
    }

    @Test
    @SneakyThrows
    void computeBigData() {
        String table = """
                №	|x1				|x2				|x3				|x4				|x5				|x6				|x7				|x8				|x9				|x10			|eps1		|eps2		|eps3		|eps4		|eps5		|eps6		|eps7		|eps8		|eps9		|eps10		|
                1	|0,200000		|1,280000		|1,052000		|0,246800		|-0,177880		|0,139908		|0,025917		|-0,076675		|0,730993		|-0,242106		| 0,200000	|1,280000	|1,052000	|0,246800	|0,177880	|0,139908	|0,025917	|0,076675	|0,730993	|0,242106	|
                2	|-0,097896		|1,139894		|1,031104		|0,252674		|-0,190381		|0,142648		|0,030975		|-0,079790		|0,801288		|-0,203051		| 0,297896	|0,140106	|0,020896	|0,005874	|0,012501	|0,002740	|0,005057	|0,003116	|0,070295	|0,039055	|
                3	|-0,092536		|1,130707		|1,020747		|0,243940		|-0,199493		|0,134721		|0,024347		|-0,086067		|0,802669		|-0,197903		| 0,005360	|0,009187	|0,010358	|0,008734	|0,009111	|0,007926	|0,006628	|0,006277	|0,001381	|0,005148	|
                4	|-0,087367		|1,134441		|1,023071		|0,245158		|-0,199307		|0,134096		|0,023121		|-0,087798		|0,801249		|-0,198666		| 0,005169	|0,003734	|0,002324	|0,001219	|0,000186	|0,000626	|0,001226	|0,001731	|0,001420	|0,000763	|
                5	|-0,087536		|1,134661		|1,023502		|0,245668		|-0,198830		|0,134463		|0,023329		|-0,087784		|0,801119		|-0,198859		| 0,000170	|0,000221	|0,000431	|0,000510	|0,000477	|0,000367	|0,000208	|0,000014	|0,000129	|0,000193	|
                6	|-0,087727		|1,134512		|1,023411		|0,245637		|-0,198810		|0,134517		|0,023398		|-0,087720		|0,801164		|-0,198838		| 0,000191	|0,000149	|0,000091	|0,000031	|0,000020	|0,000054	|0,000070	|0,000064	|0,000045	|0,000021	|
                7	|-0,087727		|1,134497		|1,023388		|0,245613		|-0,198829		|0,134505		|0,023395		|-0,087717		|0,801171		|-0,198830		| 0,000000	|0,000015	|0,000023	|0,000024	|0,000019	|0,000012	|0,000004	|0,000003	|0,000007	|0,000009	|
                8	|-0,087719		|1,134502		|1,023391		|0,245613		|-0,198831		|0,134502		|0,023392		|-0,087719		|0,801170		|-0,198830		| 0,000008	|0,000005	|0,000003	|0,000000	|0,000002	|0,000003	|0,000003	|0,000002	|0,000001	|0,000000	|
                9	|-0,087719		|1,134503		|1,023392		|0,245614		|-0,198830		|0,134503		|0,023392		|-0,087719		|0,801170		|-0,198830		| 0,000000	|0,000001	|0,000001	|0,000001	|0,000001	|0,000000	|0,000000	|0,000000	|0,000000	|0,000000	|
                10	|-0,087719		|1,134503		|1,023392		|0,245614		|-0,198830		|0,134503		|0,023392		|-0,087719		|0,801170		|-0,198830		| 0,000000	|0,000000	|0,000000	|0,000000	|0,000000	|0,000000	|0,000000	|0,000000	|0,000000	|0,000000	|
                """;
        String data = """
                10
                0.000001
                1 1 1 1 1 1 1 1 10 1 10
                1 1 1 1 1 1 1 1 1 10 1
                1 1 1 1 1 1 1 10 1 1 2
                1 1 1 1 1 1 10 1 1 1 3
                1 1 1 1 10 1 1 1 1 1 1
                1 1 1 1 1 10 1 1 1 1 4
                1 1 1 10 1 1 1 1 1 1 5
                1 10 1 1 1 1 1 1 1 1 13
                1 1 10 1 1 1 1 1 1 1 12
                10 1 1 1 1 1 1 1 1 1 2
                """;
        ByteArrayInputStream testInput = new ByteArrayInputStream(data.getBytes("UTF-8"));
        System.setIn(testInput);

        Result result = new ConsoleCommand().execute();

        assertAll(
                () -> assertIterableEquals(
                        List.of(-0.0877192784269493, 1.1345029632499413, 1.0233918577246928, 0.24561407422713682, -0.19883038291388502, 0.1345029354301362, 0.02339181094473943, -0.08771930944858908, 0.8011695751474524, -0.19883042459346756),
                        result.getResult()),
                () -> assertEquals(table, result.getTable())
        );
    }

    @Test
    @SneakyThrows
    void computeDataShouldNull() {
        String data = """
                4
                0.0001
                -16,7 -22,6 -8,73 23,0 -22,9
                -10,7 -14,4 13,6 -3,76 13,7
                5,24 7,02 -0,492 20,8 -22,1
                21,6 19,9 0,921 -20,9 -11,3
                """;
        ByteArrayInputStream testInput = new ByteArrayInputStream(data.getBytes("UTF-8"));
        System.setIn(testInput);

        Result result = new ConsoleCommand().execute();

        assertNull(result);
    }
}
