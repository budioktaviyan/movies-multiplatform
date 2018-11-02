package id.kotlin.multiplatform.presentation

import id.kotlin.multiplatform.data.MovieData
import id.kotlin.multiplatform.domain.Movie
import id.kotlin.multiplatform.presentation.MovieContract.View

class MoviePresenter(private val movie: Movie) : MovieContract.Presenter {

    private lateinit var view: MovieContract.View
    private lateinit var data: MovieData

    override fun initPresenter(view: View) {
        this.view = view
    }

    override fun showDiscoverMovie() {
        val response = getResponse()
        data = movie.run(response)
        view.onShowDiscoverMovie(data)
    }

    private fun getResponse(): String {
        return "{\"total_pages\":19248,\"results\":[{\"title\":\"Venom\",\"poster_path\":\"2uNW4WbgBXL25BAbXGLnLqX71Sw.jpg\",\"backdrop_path\":\"VuukZLgaCrho2Ar8Scl9HtV3yD.jpg\",\"overview\":\"When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego \\\"Venom\\\" to save his life.\"},{\"title\":\"Halloween\",\"poster_path\":\"bXs0zkv2iGVViZEy78teg2ycDBm.jpg\",\"backdrop_path\":\"tZ358Wk4BnOc4FjdGsiexAUvCMH.jpg\",\"overview\":\"Laurie Strode comes to her final confrontation with Michael Myers, the masked figure who has haunted her since she narrowly escaped his killing spree on Halloween night four decades ago.\"},{\"title\":\"The Seven Deadly Sins: Prisoners of the Sky\",\"poster_path\":\"lgYGPujZNckyKwQQNwMLmkWoKui.jpg\",\"backdrop_path\":\"uKwOX7MtKlAaGeCQe6c4jc1vZpj.jpg\",\"overview\":\"Traveling in search of the rare ingredient, “sky fish”  Meliodas and Hawk arrive at a palace that floats above the clouds. The people there are busy preparing a ceremony, meant to protect their home from a ferocious beast that awakens once every 3,000 years. But before the ritual is complete, the Six Knights of Black—a Demon Clan army—removes the seal on the beast, threatening the lives of everyone in the Sky Palace.\"},{\"title\":\"A Star Is Born\",\"poster_path\":\"wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg\",\"backdrop_path\":\"840rbblaLc4SVxm8gF3DNdJ0YAE.jpg\",\"overview\":\"Seasoned musician Jackson Maine discovers—and falls in love with—struggling artist Ally. She has just about given up on her dream to make it big as a singer—until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.\"},{\"title\":\"Incredibles 2\",\"poster_path\":\"x1txcDXkcM65gl7w20PwYSxAYah.jpg\",\"backdrop_path\":\"mabuNsGJgRuCTuGqjFkWe1xdu19.jpg\",\"overview\":\"Elastigirl springs into action to save the day, while Mr. Incredible faces his greatest challenge yet – taking care of the problems of his three children.\"},{\"title\":\"Night School\",\"poster_path\":\"1NSMAaBPSbWv7sGmF8oLGMNb8Qm.jpg\",\"backdrop_path\":\"7CWpvqVY5JWbEtkaenzqfJjVSal.jpg\",\"overview\":\"Teddy Walker is a successful salesman whose life takes an unexpected turn when he accidentally blows up his place of employment. Forced to attend night school to get his GED, Teddy soon finds himself dealing with a group of misfit students, his former high school nemesis and a feisty teacher who doesn't think he's too bright.\"},{\"title\":\"Mile 22\",\"poster_path\":\"hQKdZ6nnHfrWCAZ87cPnazrJEDL.jpg\",\"backdrop_path\":\"A2rIVEV2jOzb4smx8hby1u9UwAm.jpg\",\"overview\":\"An elite group of American operatives, aided by a top-secret tactical command team, must transport an asset who holds life-threatening information to an extraction point 22 miles away through the hostile streets of an Asian city.\"},{\"title\":\"The Nun\",\"poster_path\":\"sFC1ElvoKGdHJIWRpNB3xWJ9lJA.jpg\",\"backdrop_path\":\"fgsHxz21B27hOOqQBiw9L6yWcM7.jpg\",\"overview\":\"When a young nun at a cloistered abbey in Romania takes her own life, a priest with a haunted past and a novitiate on the threshold of her final vows are sent by the Vatican to investigate. Together they uncover the order’s unholy secret. Risking not only their lives but their faith and their very souls, they confront a malevolent force in the form of the same demonic nun that first terrorized audiences in “The Conjuring 2” as the abbey becomes a horrific battleground between the living and the damned.\"},{\"title\":\"Avengers: Infinity War\",\"poster_path\":\"7WsyChQLEftFiDOVTGkv3hFpyyt.jpg\",\"backdrop_path\":\"lmZFxXgJE3vgrciwuDib0N8CfQo.jpg\",\"overview\":\"As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.\"},{\"title\":\"Alpha\",\"poster_path\":\"afdZAIcAQscziqVtsEoh2PwsYTW.jpg\",\"backdrop_path\":\"nKMeTdm72LQ756Eq20uTjF1zDXu.jpg\",\"overview\":\"After a hunting expedition goes awry, a young caveman struggles against the elements to find his way home.\"},{\"title\":\"Ant-Man and the Wasp\",\"poster_path\":\"rv1AWImgx386ULjcf62VYaW8zSt.jpg\",\"backdrop_path\":\"6P3c80EOm7BodndGBUAJHHsHKrp.jpg\",\"overview\":\"Just when his time under house arrest is about to end, Scott Lang puts again his freedom at risk to help Hope van Dyne and Dr. Hank Pym dive into the quantum realm and try to accomplish, against time and any chance of success, a very dangerous rescue mission.\"},{\"title\":\"The Predator\",\"poster_path\":\"wMq9kQXTeQCHUZOG4fAe5cAxyUA.jpg\",\"backdrop_path\":\"f4E0ocYeToEuXvczZv6QArrMDJ.jpg\",\"overview\":\"From the outer reaches of space to the small-town streets of suburbia, the hunt comes home. Now, the universe’s most lethal hunters are stronger, smarter and deadlier than ever before, having genetically upgraded themselves with DNA from other species. When a young boy accidentally triggers their return to Earth, only a ragtag crew of ex-soldiers and a disgruntled science teacher can prevent the end of the human race.\"},{\"title\":\"Johnny English Strikes Again\",\"poster_path\":\"tCBxnZwLiY1BOKw3tH6AxHZdqPh.jpg\",\"backdrop_path\":\"yCOLqh5MOGyYdo58Ap0aWvKop9h.jpg\",\"overview\":\"Disaster strikes when a criminal mastermind reveals the identities of all active undercover agents in Britain. The secret service can now rely on only one man—Johnny English. Currently teaching at a minor prep school, Johnny springs back into action to find the mysterious hacker. For this mission to succeed, he’ll need all of his skills—what few he has—as the man with yesterday’s analogue methods faces off against tomorrow’s digital technology.\"},{\"title\":\"First Man\",\"poster_path\":\"i91mfvFcPPlaegcbOyjGgiWfZzh.jpg\",\"backdrop_path\":\"z1FkoHO7bz40S4JiptWHSYoPpxq.jpg\",\"overview\":\"A look at the life of the astronaut, Neil Armstrong, and the legendary space mission that led him to become the first man to walk on the Moon on July 20, 1969.\"},{\"title\":\"The Meg\",\"poster_path\":\"eyWICPcxOuTcDDDbTMOZawoOn8d.jpg\",\"backdrop_path\":\"rH79sB6Nkx4cMW3JzsUy7wK0rhX.jpg\",\"overview\":\"A deep sea submersible pilot revisits his past fears in the Mariana Trench, and accidentally unleashes the seventy foot ancestor of the Great White Shark believed to be extinct.\"},{\"title\":\"Black Panther\",\"poster_path\":\"uxzzxijgPIY7slzFvMotPv8wjKA.jpg\",\"backdrop_path\":\"b6ZJZHUdMEFECvGiDpJjlfUWela.jpg\",\"overview\":\"King T'Challa returns home from America to the reclusive, technologically advanced African nation of Wakanda to serve as his country's new leader. However, T'Challa soon finds that he is challenged for the throne by factions within his own country as well as without. Using powers reserved to Wakandan kings, T'Challa assumes the Black Panther mantel to join with girlfriend Nakia, the queen-mother, his princess-kid sister, members of the Dora Milaje (the Wakandan 'special forces') and an American secret agent, to prevent Wakanda from being dragged into a world war.\"},{\"title\":\"A-X-L\",\"poster_path\":\"9kB56ZdMB6RgY5QtX9Bar45jCeI.jpg\",\"backdrop_path\":\"l1nYo0yzKjf84atnBDbx0do16vQ.jpg\",\"overview\":\"The life of a teenage boy is forever altered by a chance encounter with cutting edge military technology.\"},{\"title\":\"Christopher Robin\",\"poster_path\":\"xR5w0he6czZkcAz459a4iPBqXGe.jpg\",\"backdrop_path\":\"uDt8bQ4lGVlabEx5Gl2cPzvy6qz.jpg\",\"overview\":\"Working-class family man Christopher Robin encounters his childhood friend Winnie-the-Pooh, who helps him to rediscover the joys of life.\"},{\"title\":\"Kung Fu League\",\"poster_path\":\"rW0A73hjzPWVwADlCTLnjLhAFLX.jpg\",\"backdrop_path\":null,\"overview\":\"Martial arts comedy following a group of kung fu legends banding together to take on the bad guys. The legends includes VINCENT ZHAO reprising his role as ‘Wong Fei Hung’ with DENNIS TO once again portraying ‘Wing Chun’ master ‘Ip Man’, DANNY CHAN KWOK KWAN as ‘Chen Zhen’ and ANDY ON as master ‘Huo Yuan Jia’.\"},{\"title\":\"BlacKkKlansman\",\"poster_path\":\"bT5WuAsjDJYQv2vXbWGDQTmjKav.jpg\",\"backdrop_path\":\"gMVdhfQ7q9DFHhDkehrququjGPd.jpg\",\"overview\":\"Ron Stallworth, an African-American police officer from Colorado, successfully manages to infiltrate the local Ku Klux Klan and become the head of the local chapter.\"}]}"
    }
}