package com.example.mynewcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout


//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ConstraintExample1() {
    ConstraintLayout(Modifier.fillMaxSize()) {

        val (boxRed, boxGreen, boxYellow, boxCyan, boxBlack) = createRefs()

        Box(
            modifier = Modifier
                .size(125.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
        )
        Box(
            modifier = Modifier
                .size(125.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    bottom.linkTo(boxYellow.top)
                    start.linkTo(boxYellow.end)

                }
        )
        Box(
            modifier = Modifier
                .size(125.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    bottom.linkTo(boxYellow.top)
                    end.linkTo(boxYellow.start)
                }
        )

        Box(
            modifier = Modifier
                .size(125.dp)
                .background(Color.Cyan)
                .constrainAs(boxCyan) {
                    top.linkTo(boxYellow.bottom)
                    end.linkTo(boxYellow.start)
                }, contentAlignment = Alignment.Center
        ) {
            Text(text = "Hola")
        }

        Box(
            modifier = Modifier
                .size(125.dp)
                .background(Color.Black)
                .constrainAs(boxBlack) {
                    top.linkTo(boxYellow.bottom)
                    start.linkTo(boxYellow.end)

                }
        )


    }
}

//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ConstraintExampleBuild() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val boxRed = createRef()
        val topGuide = createGuidelineFromTop(0.1f)
        val startGuide = createGuidelineFromStart(0.25f)

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(topGuide)
                start.linkTo(startGuide)
            })

    }
}


//@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ConstraintBarrier() {

    ConstraintLayout(Modifier.fillMaxSize()) {

        val (boxRed, boxYellow, boxGreen) = createRefs()
        val barrier = createEndBarrier(boxYellow, boxGreen)


        Box(
            modifier = Modifier
                .size(125.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    start.linkTo(parent.start, margin = 16.dp)

                }
        )
        Box(
            modifier = Modifier
                .size(235.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    top.linkTo(boxYellow.bottom)
                    start.linkTo(parent.start, margin = 16.dp)


                }
        )



        Box(
            modifier = Modifier
                .size(55.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    start.linkTo(barrier)

                }
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ConstraintChainExample() {

    ConstraintLayout(Modifier.fillMaxSize()) {
        val (boxRed, boxYellow, boxGreen) = createRefs()


        Box(
            modifier = Modifier
                .size(85.dp)
                .background(Color.Yellow)
                .constrainAs(boxYellow) {
                    start.linkTo(parent.start)
                    end.linkTo(boxGreen.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)

                }
        )
        Box(
            modifier = Modifier
                .size(85.dp)
                .background(Color.Green)
                .constrainAs(boxGreen) {
                    start.linkTo(boxYellow.end)
                    end.linkTo(boxRed.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)

                }
        )



        Box(
            modifier = Modifier
                .size(85.dp)
                .background(Color.Red)
                .constrainAs(boxRed) {
                    start.linkTo(boxGreen.end)
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)

                }
        )

        createHorizontalChain(boxYellow, boxGreen, boxRed, chainStyle = ChainStyle.Packed)
        createVerticalChain(boxYellow, boxGreen, boxRed, chainStyle = ChainStyle.Packed)
    }
}



















