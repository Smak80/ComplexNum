import kotlin.math.sqrt

class ComplexNumber(var re: Double = 0.0, var im: Double = 0.0)
{
    override fun toString() = "$re + ${im}i"

    operator fun plus(other: ComplexNumber) =
        ComplexNumber(re + other.re, im + other.im)

    operator fun minus(other: ComplexNumber) =
        ComplexNumber(re - other.re, im - other.im)

    operator fun times(other: ComplexNumber) =
        ComplexNumber(
            re*other.re - im*other.im,
            re*other.im + im*other.re
        )

    operator fun div(other: ComplexNumber) =
        (other.re*other.re + other.im*other.im).let{
        ComplexNumber(
            (re*other.re + im*other.im)/it,
            (re*other.im + im*other.re)/it
        )
    }

    operator fun plusAssign(other: ComplexNumber)
    {
        re += other.re
        im += other.im
    }

    operator fun timesAssign(other: ComplexNumber)
    {
        val temp_re = re*other.re - im*other.im
        im = re*other.im + im*other.re
        re = temp_re
    }

    fun abs() = sqrt(re*re + im*im)

    operator fun unaryMinus() = ComplexNumber(re, -im)

    override fun equals(other: Any?): Boolean = other?.let{
        if (it is ComplexNumber)
        {
            it.re == re && it.im == im
        } else
            false
    } ?: false

    override fun hashCode(): Int {
        var result = re.hashCode()
        result = 31 * result + im.hashCode()
        return result
    }

}

fun main()
{
    val first_num = ComplexNumber(5.0, 2.0)
    val second_num = ComplexNumber(3.0, 1.0)
    println(first_num * second_num)
    //first_num *= second_num
    println(first_num)
    println(first_num.abs())
    println(-first_num)
    //println(ComplexNumber(im=-1.0))
}