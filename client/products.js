!(function (e) {
  function t(t) {
    for (
      var l, u, o = t[0], s = t[1], c = t[2], i = 0, f = [];
      i < o.length;
      i++
    )
      (u = o[i]), n[u] && f.push(n[u][0]), (n[u] = 0)
    for (l in s) Object.prototype.hasOwnProperty.call(s, l) && (e[l] = s[l])
    for (d && d(t); f.length; ) f.shift()()
    return r.push.apply(r, c || []), a()
  }
  function a() {
    for (var e, t = 0; t < r.length; t++) {
      for (var a = r[t], l = !0, o = 1; o < a.length; o++) {
        var s = a[o]
        0 !== n[s] && (l = !1)
      }
      l && (r.splice(t--, 1), (e = u((u.s = a[0]))))
    }
    return e
  }
  var l = {},
    n = { 9: 0 },
    r = []
  function u(t) {
    if (l[t]) return l[t].exports
    var a = (l[t] = { i: t, l: !1, exports: {} })
    return e[t].call(a.exports, a, a.exports, u), (a.l = !0), a.exports
  }
  ;(u.m = e),
    (u.c = l),
    (u.d = function (e, t, a) {
      u.o(e, t) || Object.defineProperty(e, t, { enumerable: !0, get: a })
    }),
    (u.r = function (e) {
      'undefined' != typeof Symbol &&
        Symbol.toStringTag &&
        Object.defineProperty(e, Symbol.toStringTag, { value: 'Module' }),
        Object.defineProperty(e, '__esModule', { value: !0 })
    }),
    (u.t = function (e, t) {
      if ((1 & t && (e = u(e)), 8 & t)) return e
      if (4 & t && 'object' == typeof e && e && e.__esModule) return e
      var a = Object.create(null)
      if (
        (u.r(a),
        Object.defineProperty(a, 'default', { enumerable: !0, value: e }),
        2 & t && 'string' != typeof e)
      )
        for (var l in e)
          u.d(
            a,
            l,
            function (t) {
              return e[t]
            }.bind(null, l)
          )
      return a
    }),
    (u.n = function (e) {
      var t =
        e && e.__esModule
          ? function () {
              return e.default
            }
          : function () {
              return e
            }
      return u.d(t, 'a', t), t
    }),
    (u.o = function (e, t) {
      return Object.prototype.hasOwnProperty.call(e, t)
    }),
    (u.p = '')
  var o = (window.webpackJsonp = window.webpackJsonp || []),
    s = o.push.bind(o)
  ;(o.push = t), (o = o.slice())
  for (var c = 0; c < o.length; c++) t(o[c])
  var d = s
  r.push([38, 0]), a()
})([
  ,
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var l,
      n = a(0),
      r = (l = n) && l.__esModule ? l : { default: l }
    class u extends r.default.Component {
      render() {
        return r.default.createElement(
          'a',
          { href: this.props.url },
          r.default.createElement('img', {
            className: 'socialMenuItem',
            src: this.props.image
          })
        )
      }
    }
    t.default = u
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var l = o(a(0)),
      n = o(a(6)),
      r = o(a(8)),
      u = o(a(10))
    function o(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class s extends l.default.Component {
      render() {
        return l.default.createElement(
          'ul',
          { className: 'menu' },
          l.default.createElement(
            'li',
            null,
            l.default.createElement(n.default, {
              username: this.props.facebook.username
            })
          ),
          l.default.createElement(
            'li',
            null,
            l.default.createElement(r.default, {
              username: this.props.twitter.username
            })
          ),
          l.default.createElement(
            'li',
            null,
            l.default.createElement(u.default, {
              username: this.props.github.username,
              dark: this.props.github.dark
            })
          )
        )
      }
    }
    t.default = s
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var l = r(a(0)),
      n = r(a(4))
    r(a(14))
    function r(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class u extends l.default.Component {
      render() {
        return l.default.createElement(
          'div',
          { className: 'header' },
          l.default.createElement(
            'nav',
            { class: 'navbar navbar-expand-md navbar-dark bg-dark' },
            l.default.createElement('img', {
              src: n.default,
              width: '180',
              height: '180'
            }),
            l.default.createElement(
              'div',
              { className: 'company-title mr-auto' },
              l.default.createElement('h1', null, 'HartCode'),
              l.default.createElement('h2', null, 'Game Studio')
            ),
            l.default.createElement(
              'button',
              {
                class: 'navbar-toggler',
                type: 'button',
                'data-toggle': 'collapse',
                'data-target': '#navbarNav',
                'aria-controls': 'navbarNav',
                'aria-expanded': 'false',
                'aria-label': 'Toggle navigation'
              },
              l.default.createElement('span', { class: 'navbar-toggler-icon' })
            ),
            l.default.createElement(
              'div',
              { class: 'collapse navbar-collapse', id: 'navbarNav' },
              l.default.createElement(
                'ul',
                { class: 'navbar-nav ml-auto' },
                l.default.createElement(
                  'li',
                  { className: 'nav-item' },
                  l.default.createElement(
                    'a',
                    { className: 'nav-link', href: '/products' },
                    'Products'
                  )
                ),
                l.default.createElement(
                  'li',
                  { className: 'nav-item' },
                  l.default.createElement(
                    'a',
                    { className: 'nav-link', href: '/hire' },
                    'Hire Us'
                  )
                ),
                l.default.createElement(
                  'li',
                  { className: 'nav-item' },
                  l.default.createElement(
                    'a',
                    { className: 'nav-link', href: '/about' },
                    'About'
                  )
                )
              )
            )
          )
        )
      }
    }
    t.default = u
  },
  function (e, t, a) {
    e.exports = a.p + '../83bac1b50602cac313ef8ceb4868ad3e.png'
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var l = r(a(0)),
      n = r(a(2))
    function r(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class u extends l.default.Component {
      render() {
        return l.default.createElement(
          'div',
          { className: 'footer' },
          l.default.createElement(
            'ul',
            { className: 'menu' },
            l.default.createElement(
              'li',
              null,
              l.default.createElement('a', { href: '/' }, 'Home')
            ),
            l.default.createElement(
              'li',
              null,
              l.default.createElement('a', { href: '/careers' }, 'Careers')
            ),
            l.default.createElement(
              'li',
              null,
              l.default.createElement('a', { href: '/contact' }, 'Contact Us')
            )
          ),
          l.default.createElement(n.default, {
            facebook: { username: 'hartcodellc' },
            twitter: { username: 'hartcode' },
            github: { username: 'hartcode' }
          })
        )
      }
    }
    t.default = u
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var l = u(a(0)),
      n = u(a(7)),
      r = u(a(1))
    function u(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class o extends l.default.Component {
      render() {
        var e = 'https://facebook.com/' + this.props.username
        return l.default.createElement(r.default, { url: e, image: n.default })
      }
    }
    t.default = o
  },
  function (e, t, a) {
    e.exports = a.p + '../46b6ac49f3ed295918c8fae5050f9276.png'
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var l = u(a(0)),
      n = u(a(9)),
      r = u(a(1))
    function u(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class o extends l.default.Component {
      render() {
        var e = 'https://twitter.com/' + this.props.username
        return l.default.createElement(r.default, { url: e, image: n.default })
      }
    }
    t.default = o
  },
  function (e, t, a) {
    e.exports = a.p + '../664a1f44ed01e235d4bf54d3e5bfe887.png'
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var l = o(a(0)),
      n = o(a(11)),
      r = o(a(12)),
      u = o(a(1))
    function o(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class s extends l.default.Component {
      render() {
        var e = 'https://github.com/' + this.props.username,
          t = n.default
        return (
          'true' === this.props.dark && (t = r.default),
          l.default.createElement(u.default, { url: e, image: t })
        )
      }
    }
    t.default = s
  },
  function (e, t, a) {
    e.exports = a.p + '../d56df49a807a9fd06eb1667a84d3810e.png'
  },
  function (e, t, a) {
    e.exports = a.p + '../0507ea4d8b2d4c92e7e76f7df0fa8ddd.png'
  },
  function (e, t, a) {
    'use strict'
    t.analytics = function () {
      var e, t, a, l, n, r
      ;(e = window),
        (t = document),
        (a = 'script'),
        (l = 'ga'),
        (e.GoogleAnalyticsObject = l),
        (e.ga =
          e.ga ||
          function () {
            ;(e.ga.q = e.ga.q || []).push(arguments)
          }),
        (e.ga.l = 1 * new Date()),
        (n = t.createElement(a)),
        (r = t.getElementsByTagName(a)[0]),
        (n.async = 1),
        (n.src = 'https://www.google-analytics.com/analytics.js'),
        r.parentNode.insertBefore(n, r),
        ga('create', 'UA-20488226-1', 'auto'),
        ga('send', 'pageview')
    }
  },
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  ,
  function (e, t, a) {
    'use strict'
    var l,
      n = a(39),
      r = a(15),
      u = a(13)
    ;((l = u) && l.__esModule ? l : { default: l }).default.analytics()
    var o = document.getElementById('root')
    null !== o && (0, r.render)((0, n.renderRoot)(), o)
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 }),
      (t.renderRoot = function () {
        return l.default.createElement(
          'div',
          null,
          l.default.createElement(n.default, null),
          l.default.createElement(
            'div',
            { className: 'body' },
            l.default.createElement('h1', null, 'Products'),
            l.default.createElement(
              'h2',
              null,
              'Treasure Fighter - In Development'
            ),
            l.default.createElement('img', { src: u.default }),
            l.default.createElement(
              'p',
              null,
              "The King has a big problem, it seems that all of his treasure has come to life and is now attacking people. You play a janitor who is mistaken for a knight, and sent down into the castle depths to subdue the King''s treasure. This side scrolling game focuses on short casual battles with various treasure based enemies.",
              l.default.createElement(
                'ul',
                null,
                l.default.createElement(
                  'li',
                  null,
                  'Jump, Slash, Kick, and Crouch your way to victory whilest battling treasure.'
                ),
                l.default.createElement('li', null, 'Collect loot!'),
                l.default.createElement(
                  'li',
                  null,
                  'Purchase upgrades at the castle armory.'
                ),
                l.default.createElement(
                  'li',
                  null,
                  'Life Hearts, you need em, we got em.'
                ),
                l.default.createElement('li', null, 'Coming Soon!')
              )
            ),
            l.default.createElement(
              'h2',
              null,
              'So You Want To Build A Snowman'
            ),
            l.default.createElement('img', { src: o.default }),
            l.default.createElement(
              'p',
              null,
              l.default.createElement(
                'a',
                {
                  href:
                    'https://alexhart.itch.io/so-you-want-to-build-a-snowman'
                },
                'https://alexhart.itch.io/so-you-want-to-build-a-snowman'
              )
            ),
            l.default.createElement(
              'p',
              null,
              "Take control of the coolest person in the snow globe, the snowman. Life is great for this little snowman until someone shakes the snow globe and all of his pieces fall off. Now it''s up to you to track down all of the pieces of the snowman, and put him back together."
            ),
            l.default.createElement(
              'ul',
              null,
              l.default.createElement(
                'li',
                null,
                ' Explore the tiny world of a snow globe.'
              ),
              l.default.createElement(
                'li',
                null,
                'Collect zany objects to rebuild a snowman'
              ),
              l.default.createElement('li', null, 'Clear Objectives'),
              l.default.createElement(
                'li',
                null,
                'Replay again to build a new snowman with different pieces.'
              ),
              l.default.createElement('li', null, 'For All Ages'),
              l.default.createElement(
                'li',
                null,
                'Made in a little over 12 hours.'
              ),
              l.default.createElement('li', null, 'No pesky audio to mute.'),
              l.default.createElement(
                'li',
                null,
                'Uses Standard FPS controls - Mouse Look, WASD movement'
              ),
              l.default.createElement(
                'li',
                null,
                'Open Source - if you find a bug please post an issue on github',
                ' ',
                l.default.createElement(
                  'a',
                  {
                    href: 'https://github.com/hartalex/soyouwanttobuildasnowman'
                  },
                  'https://github.com/hartalex/soyouwanttobuildasnowman'
                )
              ),
              l.default.createElement(
                'li',
                null,
                'This game was created during Ludum Dare 38. ldjam.com'
              )
            ),
            l.default.createElement('h2', null, 'Money Drop'),
            l.default.createElement('img', { src: s.default }),
            l.default.createElement(
              'p',
              null,
              l.default.createElement(
                'a',
                { href: 'https://alexhart.itch.io/money-drop' },
                'https://alexhart.itch.io/money-drop'
              )
            ),
            l.default.createElement(
              'p',
              null,
              'Catch as much money as you can while avoiding the bombs.'
            ),
            l.default.createElement(
              'ul',
              null,
              l.default.createElement(
                'li',
                null,
                'See who can get the highest score'
              )
            ),
            l.default.createElement('h2', null, 'Zombone'),
            l.default.createElement('img', { src: c.default }),
            l.default.createElement(
              'p',
              null,
              l.default.createElement(
                'a',
                { href: 'https://alexhart.itch.io/zombone' },
                'https://alexhart.itch.io/zombone'
              )
            ),
            l.default.createElement(
              'p',
              null,
              'You are alone in a graveyard trying to survive a zombie attack.'
            ),
            l.default.createElement(
              'ul',
              null,
              l.default.createElement('li', null, 'Zombies!'),
              l.default.createElement(
                'li',
                null,
                'See who can get the highest score'
              )
            )
          ),
          l.default.createElement(r.default, null)
        )
      })
    var l = d(a(0)),
      n = d(a(3)),
      r = d(a(5)),
      u = d(a(40)),
      o = d(a(41)),
      s = d(a(42)),
      c = d(a(43))
    function d(e) {
      return e && e.__esModule ? e : { default: e }
    }
  },
  function (e, t, a) {
    e.exports = a.p + '../010957151cfa8e77a1e5cdd11620d4ba.gif'
  },
  function (e, t, a) {
    e.exports = a.p + '../9dfce5f77e66db7d62f659da2a67f957.png'
  },
  function (e, t, a) {
    e.exports = a.p + '../05e0a933692af7ee68024daa6d1639d9.png'
  },
  function (e, t, a) {
    e.exports = a.p + '../c2ad2a92bf471a7587f9b998343c8bc8.png'
  }
])
