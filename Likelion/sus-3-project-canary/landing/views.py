from django.shortcuts import render


def landing(request):
    from datetime import datetime
    context = {
        "weather": "비",
        "temperature": 29,
        "weather_data": {
            "weather": "맑음",
            "temperature": 32,
        },
        "top_average": [
            "이정후", "강백호", "전준우"
        ],
        "top_hitters": [
            {
                "name": "이정후",
                "average": "0.350",
            },
            {
                "name": "강백호",
                "average": "0.349",
            },
            {
                "name": "전준우",
                "average": "0.348",
            },
        ],
        "now": datetime.now(),
    }

    return render(request, "landing/index.html", context)