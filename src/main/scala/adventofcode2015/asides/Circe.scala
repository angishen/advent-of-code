package adventofcode2015.asides

import scala.io.Source
import io.circe._
import io.circe.parser._
import io.circe.syntax._

object Circe extends App {
  val input = Source.fromResource("sample.json").mkString

  // extract data from json file
  val json = parse(input).getOrElse(Json.Null)

  val cursor: HCursor = json.hcursor

  val baz: Decoder.Result[Double] = cursor.downField("values").downField("baz").as[Double]
  val bar: Decoder.Result[Boolean] = cursor.downField("values").downField("bar").as[Boolean]

  // shorthand for downField("qux).as[A]
  val qux: Decoder.Result[List[String]] = cursor.downField("values").get[List[String]]("qux")

  println(baz, bar, qux)

  // transform json
  val reversedNameCursor: ACursor = cursor.downField("name").withFocus(_.mapString(_.reverse))
  val reversedName: Option[Decoder.Result[String]] = reversedNameCursor.top
    .map(_.hcursor)
    .map(_.get[String]("name"))

  reversedName.map(println)

  // encoding and decoding
  val intsJson = List("hello", "how", "are", "you").asJson

  println(intsJson)

  println(decode[List[Int]]("[1, 2, 3]"))

  // semi-auto
  case class Menu(value: String, popUp: PopUp)
  case class PopUp(menuItem: List[MenuItem])
  case class MenuItem(value: String, onClick: Option[String])

//  implicit val menuDecoder: Decoder[Menu] = deriveDecoder[Menu]
//  implicit val PopUpDecoder: Decoder[PopUp] = deriveDecoder[PopUp]
//  implicit val MenuItemDecoder: Decoder[MenuItem] = deriveDecoder[MenuItem]
//
//  implicit val menuDecoder: Decoder[Menu] = Decoder.forProduct2("value", "popup")(Menu.apply)
//  implicit val PopUpDecoder: Decoder[PopUp] = Decoder.forProduct1("menuitem")(PopUp.apply)
//  implicit val MenuItemDecoder: Decoder[MenuItem] = Decoder.forProduct2("value", "onclick")(MenuItem.apply)

  implicit val MenuDecoder: Decoder[Menu] = (c: HCursor) => {
    for {
      value <- c.downField("value").as[String]
      popUp <- c.downField("popup").as[PopUp]
    } yield Menu(value, popUp)
  }

  implicit val PopUpDecoder: Decoder[PopUp] = (c: HCursor) => {
    c.downField("menuitem").as[List[MenuItem]].map(PopUp(_))
  }

  implicit val MenuItemDecoder: Decoder[MenuItem] = (c: HCursor) => {
    for {
      value <- c.downField("value").as[String]
      onClick <- c.downField("onclick").as[Option[String]]
    } yield MenuItem(value, onClick)
  }

  val menuJson = parse(Source.fromResource("menu.json").mkString).getOrElse(Json.Null)

  val decodedMenu = menuJson.hcursor.downField("menu").as[Menu]

  println(decodedMenu)
}
