!(function (e) {
  function t(t) {
    for (
      var n, u, o = t[0], c = t[1], d = t[2], f = 0, i = [];
      f < o.length;
      f++
    )
      (u = o[f]), r[u] && i.push(r[u][0]), (r[u] = 0)
    for (n in c) Object.prototype.hasOwnProperty.call(c, n) && (e[n] = c[n])
    for (s && s(t); i.length; ) i.shift()()
    return l.push.apply(l, d || []), a()
  }
  function a() {
    for (var e, t = 0; t < l.length; t++) {
      for (var a = l[t], n = !0, o = 1; o < a.length; o++) {
        var c = a[o]
        0 !== r[c] && (n = !1)
      }
      n && (l.splice(t--, 1), (e = u((u.s = a[0]))))
    }
    return e
  }
  var n = {},
    r = { 6: 0 },
    l = []
  function u(t) {
    if (n[t]) return n[t].exports
    var a = (n[t] = { i: t, l: !1, exports: {} })
    return e[t].call(a.exports, a, a.exports, u), (a.l = !0), a.exports
  }
  ;(u.m = e),
    (u.c = n),
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
        for (var n in e)
          u.d(
            a,
            n,
            function (t) {
              return e[t]
            }.bind(null, n)
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
    c = o.push.bind(o)
  ;(o.push = t), (o = o.slice())
  for (var d = 0; d < o.length; d++) t(o[d])
  var s = c
  l.push([36, 0]), a()
})([
  ,
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var n,
      r = a(0),
      l = (n = r) && n.__esModule ? n : { default: n }
    class u extends l.default.Component {
      render() {
        return l.default.createElement(
          'a',
          { href: this.props.url },
          l.default.createElement('img', {
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
    var n = o(a(0)),
      r = o(a(6)),
      l = o(a(8)),
      u = o(a(10))
    function o(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class c extends n.default.Component {
      render() {
        return n.default.createElement(
          'ul',
          { className: 'menu' },
          n.default.createElement(
            'li',
            null,
            n.default.createElement(r.default, {
              username: this.props.facebook.username
            })
          ),
          n.default.createElement(
            'li',
            null,
            n.default.createElement(l.default, {
              username: this.props.twitter.username
            })
          ),
          n.default.createElement(
            'li',
            null,
            n.default.createElement(u.default, {
              username: this.props.github.username,
              dark: this.props.github.dark
            })
          )
        )
      }
    }
    t.default = c
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var n = l(a(0)),
      r = l(a(4))
    l(a(14))
    function l(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class u extends n.default.Component {
      render() {
        return n.default.createElement(
          'div',
          { className: 'header' },
          n.default.createElement(
            'nav',
            { class: 'navbar navbar-expand-md navbar-dark bg-dark' },
            n.default.createElement('img', {
              src: r.default,
              width: '180',
              height: '180'
            }),
            n.default.createElement(
              'div',
              { className: 'company-title mr-auto' },
              n.default.createElement('h1', null, 'HartCode'),
              n.default.createElement('h2', null, 'Game Studio')
            ),
            n.default.createElement(
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
              n.default.createElement('span', { class: 'navbar-toggler-icon' })
            ),
            n.default.createElement(
              'div',
              { class: 'collapse navbar-collapse', id: 'navbarNav' },
              n.default.createElement(
                'ul',
                { class: 'navbar-nav ml-auto' },
                n.default.createElement(
                  'li',
                  { className: 'nav-item' },
                  n.default.createElement(
                    'a',
                    { className: 'nav-link', href: '/products' },
                    'Products'
                  )
                ),
                n.default.createElement(
                  'li',
                  { className: 'nav-item' },
                  n.default.createElement(
                    'a',
                    { className: 'nav-link', href: '/hire' },
                    'Hire Us'
                  )
                ),
                n.default.createElement(
                  'li',
                  { className: 'nav-item' },
                  n.default.createElement(
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
    var n = l(a(0)),
      r = l(a(2))
    function l(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class u extends n.default.Component {
      render() {
        return n.default.createElement(
          'div',
          { className: 'footer' },
          n.default.createElement(
            'ul',
            { className: 'menu' },
            n.default.createElement(
              'li',
              null,
              n.default.createElement('a', { href: '/' }, 'Home')
            ),
            n.default.createElement(
              'li',
              null,
              n.default.createElement('a', { href: '/careers' }, 'Careers')
            ),
            n.default.createElement(
              'li',
              null,
              n.default.createElement('a', { href: '/contact' }, 'Contact Us')
            )
          ),
          n.default.createElement(r.default, {
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
    var n = u(a(0)),
      r = u(a(7)),
      l = u(a(1))
    function u(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class o extends n.default.Component {
      render() {
        var e = 'https://facebook.com/' + this.props.username
        return n.default.createElement(l.default, { url: e, image: r.default })
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
    var n = u(a(0)),
      r = u(a(9)),
      l = u(a(1))
    function u(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class o extends n.default.Component {
      render() {
        var e = 'https://twitter.com/' + this.props.username
        return n.default.createElement(l.default, { url: e, image: r.default })
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
    var n = o(a(0)),
      r = o(a(11)),
      l = o(a(12)),
      u = o(a(1))
    function o(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class c extends n.default.Component {
      render() {
        var e = 'https://github.com/' + this.props.username,
          t = r.default
        return (
          'true' === this.props.dark && (t = l.default),
          n.default.createElement(u.default, { url: e, image: t })
        )
      }
    }
    t.default = c
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
      var e, t, a, n, r, l
      ;(e = window),
        (t = document),
        (a = 'script'),
        (n = 'ga'),
        (e.GoogleAnalyticsObject = n),
        (e.ga =
          e.ga ||
          function () {
            ;(e.ga.q = e.ga.q || []).push(arguments)
          }),
        (e.ga.l = 1 * new Date()),
        (r = t.createElement(a)),
        (l = t.getElementsByTagName(a)[0]),
        (r.async = 1),
        (r.src = 'https://www.google-analytics.com/analytics.js'),
        l.parentNode.insertBefore(r, l),
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
  function (e, t, a) {
    'use strict'
    var n,
      r = a(37),
      l = a(15),
      u = a(13)
    ;((n = u) && n.__esModule ? n : { default: n }).default.analytics()
    var o = document.getElementById('root')
    null !== o && (0, l.render)((0, r.renderRoot)(), o)
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 }),
      (t.renderRoot = function () {
        return n.default.createElement(
          'div',
          null,
          n.default.createElement(r.default, null),
          n.default.createElement(
            'div',
            { className: 'body' },
            n.default.createElement('h1', null, 'Hire Us'),
            n.default.createElement(
              'p',
              null,
              'We are always looking for more opportunities in the game development industry.'
            ),
            n.default.createElement(
              'p',
              null,
              'We wear many hats and are available to Code, Create, Write, or Design anything you might need.'
            ),
            n.default.createElement(
              'p',
              null,
              'We occasionally post videos of things we are working on ',
              n.default.createElement(
                'a',
                { href: 'https://www.youtube.com/user/hartac83/' },
                'Youtube'
              ),
              '.'
            ),
            n.default.createElement(
              'p',
              null,
              'Also we have 3D art up on ',
              n.default.createElement(
                'a',
                { href: 'https://sketchfab.com/hartalex' },
                'Sketchfab'
              ),
              '.'
            ),
            n.default.createElement(
              'p',
              null,
              'Checkout our open source repositories at ',
              n.default.createElement(
                'a',
                { href: 'https://github.com/hartalex/' },
                'Github'
              ),
              '.'
            ),
            n.default.createElement(
              'p',
              null,
              'Send us an email at ',
              n.default.createElement(
                'a',
                { href: 'mailto:contact@hartcode.com' },
                'contact@hartcode.com'
              ),
              '.'
            )
          ),
          n.default.createElement(l.default, null)
        )
      })
    var n = u(a(0)),
      r = u(a(3)),
      l = u(a(5))
    function u(e) {
      return e && e.__esModule ? e : { default: e }
    }
  }
])
