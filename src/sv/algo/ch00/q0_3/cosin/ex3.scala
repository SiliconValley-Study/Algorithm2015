package chapter0

import scala.util.control.Breaks

object ex3 {
	def main(args: Array[String]): Unit = {
		val argsCnt : Int = args.length
		
		if( argsCnt > 0 )
		{
			var arrNum : Array[String] = null
			var arrNumCnt : Int = 0
		    var startIdx : Int = 0
		    var endIdx : Int = 0
		    
		    for( i <- 0 until argsCnt )
		    {
		        args(i) match
		        {
		            case "-array" => {
		                arrNum = args( i + 1 ).split(",")
		                
		                arrNumCnt = arrNum.length
		            }
		            case "-start" => {
		                startIdx = args( i + 1 ).toInt
		            }
		            case "-end" => {
		            	endIdx = args( i + 1 ).toInt
		            }
		            case default => {
		                
		            }
		        }
		    }
			
			arrNum = rotation( arrNum, startIdx, endIdx )
			
			for( i <- 0 until arrNum.length )
			{
			    println(arrNum(i))
			}
		}
		else
		{
			message
		}
	}
	
	def rotation( arrNum : Array[String], startIdx : Int, endIdx : Int ) : Array[String] = {
	    val rotationArrNum : Array[String] = arrNum
	    
	    var startNum = startIdx
	    var endNum = endIdx
	    
	    val loop = new Breaks

	    loop.breakable {
			for( i <- 0 to (endIdx - startIdx) )
		    {
		        var num1 = arrNum(endNum)
		        var num2 = arrNum(startNum)
		        
		        rotationArrNum(startNum) = num1
		        rotationArrNum(endNum) = num2
		        
		        startNum += 1
		        endNum -= 1
		        
		        if( startNum > endNum)
		            loop.break
		    }
	    }
	    
	    return rotationArrNum
	}
	
	def message() {
	    println( "ex3 -array <number1,number2,...> -start <number> -end <number>" )
	    println( "\t-array : Array Number(Int)" )
	    println( "\t-start : rotate start" )
	    println( "\t-end : rotate end" )
	}
}