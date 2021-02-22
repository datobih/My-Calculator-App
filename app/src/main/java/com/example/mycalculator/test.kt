package com.example.mycalculator

import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder






fun multi(ans:Float,word:String,start:Int,end:Int):Float {
    var i = start

    var concat = ""

    var operator = 'n'

    var ansNo = ans
    var checkfirs = false
    var initNo = 0f
    var checkk = false
    var cummu= 0
    var checkv=false

    var multiNo = 0f

    while (i <= end) {


if(word[i]<'0'){
            if((i==0&&word[i]=='-')||(i>0 && word[i-1]<'0')){
        concat=concat+word[i]
    }

    else if(operator=='t'){

                if(checkv==true){
                    multiNo=ansNo

                    multiNo = multiNo * (initNo + concat.toInt())
                    checkfirs=true
                    concat = ""
                    operator = 'n'
                    checkv=false
                }

else if(checkk==false) {
    multiNo = multiNo + initNo * concat.toInt()
    checkfirs=true
    concat = ""
    operator = 'n'
}
                else{
    multiNo = multiNo - initNo * concat.toInt()
    checkfirs=true
    concat = ""
    operator = 'n'
    checkk=false
                }


        if(word[i]=='*'){

            initNo=multiNo
            multiNo=0f
            operator='t'
        }

                if(word[i]=='/'){

                    initNo=multiNo
                    multiNo=0f
                    operator='d'
                }





                if(word[i]=='+'||word[i]=='-'){
initNo=0f
                    concat=""
if(word[i]=='-'){
    checkk=true
}

                }

    }



            else if(operator=='d'){

                if(checkv==true){
                    multiNo=ansNo

                    multiNo = multiNo / (initNo + concat.toInt())
                    checkfirs=true
                    concat = ""
                    operator = 'n'
                    checkv=false
                }

                else if(checkk==false) {
                    multiNo = multiNo + initNo / concat.toInt()
                    checkfirs=true
                    concat = ""
                    operator = 'n'
                }
                else{
                    multiNo = multiNo - initNo / concat.toInt()
                    checkfirs=true
                    concat = ""
                    operator = 'n'
                    checkk=false
                }


                if(word[i]=='*'){

                    initNo=multiNo
                    multiNo=0f
                    operator='t'
                }

                if(word[i]=='/'){

                    initNo=multiNo
                    multiNo=0f
                    operator='d'
                }




                if(word[i]=='+'||word[i]=='-'){
                    initNo=0f
                    concat=""
                    if(word[i]=='-'){
                        checkk=true
                    }

                }

            }




            else if(word[i]=='*') {
try {
    initNo=initNo+concat.toInt()
}
catch (e:java.lang.NumberFormatException){
    initNo=initNo+0

    checkv=true
}

                operator='t'

        concat = ""

    }


            else if(word[i]=='/') {
                try {
                    initNo=initNo+concat.toInt()
                }
                catch (e:java.lang.NumberFormatException){
                    initNo=initNo+0

                    checkv=true
                }

                operator='d'

                concat = ""

            }



    if(operator=='n'){

        if(word[i]=='+'||word[i]=='-'){
            initNo=0f
            concat=""
            if(word[i]=='-'){
                checkk=true
            }

        }



    }


}



        else{
    concat=concat+word[i]
        }




i++
    }
    if(checkfirs==true){
    ansNo=multiNo
    }
    return ansNo
}


    fun add(ans: Float, word: String, start: Int, end: Int): Float {

        var i = start

        var concat = ""

        var operator = 'n'

        var ansNo = ans
        var checkfirs = false

        var reset = false

        while (i <= end) {

            if ((i == 0) && (word[i] > '0')) {
                var j = i
                var ignore = false
                while (j < end) {

                    if (ignore == true) {
                        i = j
                        if ((word[j] == '+' || word[j] == '-') && (word[i - 1] != '*')) {

                            reset = true
                            break

                        }
                    }

                    if (word[j] == '+' || word[j] == '-') {
                        break
                    }

                    if (word[j] == '*' || word[j] == '/') {


                        ignore = true
                    }

                    j++
                }

            }



            if (word[i] < '0') {


                if (operator == 'm') {
                    ansNo = ansNo - concat.toInt()
                    concat = ""

                    if (word[i] == '-') {
                        operator = 'm'
                    } else {
                        operator = 'n'
                    }
                } else if (operator == 'p') {
                    try {
                        ansNo = ansNo + concat.toInt()
                    }
                    catch (e:java.lang.NumberFormatException){
                        ansNo=ansNo+0
                    }
                        concat = ""

                    if (word[i] == '+') {
                        operator = 'p'
                    } else {
                        operator = 'n'
                    }
                }


                if (word[i] == '-') {

                    var j = i + 1
                    var ignore = false
                    while (j < end) {

                        if (ignore == true) {
                            i = j
                            if ((word[j] == '+' || word[j] == '-') && (word[i - 1] != '*')) {


                                reset = true
                                break

                            }
                        }

                        if ((word[j] == '+' || word[j] == '-') && (word[i - 1] != '*')) {
                            break
                        }

                        if (word[j] == '*' || word[j] == '/') {


                            ignore = true
                        }

                        j++
                    }





                    try {
                        ansNo = ansNo + concat.toInt()
                    } catch (e: NumberFormatException) {
                        ansNo = ansNo + 0
                    }
                    concat = ""

                    if (reset == true) {
                        reset = false
                        continue

                    }

                    if (i > 0) {
                        if (word[i - 1] < '0') {
                            i++
                            checkfirs = true
                            continue
                        } else {
                            operator = 'm'
                            i++
                            continue
                        }
                    } else if (i == 0) {

                        i++
                        checkfirs = true
                        continue

                    }


                }

                if (word[i] == '+') {


                    var j = i + 1
                    var ignore = false
                    while (j < end) {

                        if (ignore == true) {
                            i = j
                            if (word[j] == '+' || word[j] == '-') {

                                reset = true
                                break

                            }
                        }

                        if (word[j] == '+' || word[j] == '-') {
                            break
                        }

                        if (word[j] == '*' || word[j] == '/') {


                            ignore = true
                        }

                        j++
                    }


                    try {
                        ansNo = ansNo + concat.toInt()
                    } catch (e: NumberFormatException) {
                        ansNo = ansNo + 0
                    }

                    concat = ""

                    if (reset == true) {
                        reset = false
                        continue

                    }

                    if (i > 0) {
                        if (word[i - 1] < '0') {
                            i++
                            checkfirs = true
                            continue
                        } else {
                            operator = 'p'
                            i++
                            continue
                        }
                    } else if (i == 0) {

                        i++
                        checkfirs = true
                        continue

                    }


                }


            } else {
                if (checkfirs == false) {
                    concat = concat + word[i]
                } else {

                    concat = "-" + concat + word[i]
                    checkfirs = false
                }

            }


            i++

        }
        return ansNo

    }


    fun main() {

        var answer = "2*5/5"
        var i = 0
        answer = answer + " "

        /*if(answer[0]!='-') {
        var sb = StringBuilder(answer).also { it.insert(0, '+') }

        answer = sb.toString()
    }
    */



        var ansNo:Float = 0f




        ansNo = multi(ansNo, answer, 0, answer.lastIndex)

        ansNo = add(ansNo, answer, 0, answer.lastIndex)

print (ansNo)
    }

