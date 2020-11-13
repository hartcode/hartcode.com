!(function (e) {
  function t(t) {
    for (
      var n, i, l = t[0], s = t[1], u = t[2], c = 0, f = [];
      c < l.length;
      c++
    )
      (i = l[c]), r[i] && f.push(r[i][0]), (r[i] = 0)
    for (n in s) Object.prototype.hasOwnProperty.call(s, n) && (e[n] = s[n])
    for (d && d(t); f.length; ) f.shift()()
    return o.push.apply(o, u || []), a()
  }
  function a() {
    for (var e, t = 0; t < o.length; t++) {
      for (var a = o[t], n = !0, l = 1; l < a.length; l++) {
        var s = a[l]
        0 !== r[s] && (n = !1)
      }
      n && (o.splice(t--, 1), (e = i((i.s = a[0]))))
    }
    return e
  }
  var n = {},
    r = { 11: 0 },
    o = []
  function i(t) {
    if (n[t]) return n[t].exports
    var a = (n[t] = { i: t, l: !1, exports: {} })
    return e[t].call(a.exports, a, a.exports, i), (a.l = !0), a.exports
  }
  ;(i.m = e),
    (i.c = n),
    (i.d = function (e, t, a) {
      i.o(e, t) || Object.defineProperty(e, t, { enumerable: !0, get: a })
    }),
    (i.r = function (e) {
      'undefined' != typeof Symbol &&
        Symbol.toStringTag &&
        Object.defineProperty(e, Symbol.toStringTag, { value: 'Module' }),
        Object.defineProperty(e, '__esModule', { value: !0 })
    }),
    (i.t = function (e, t) {
      if ((1 & t && (e = i(e)), 8 & t)) return e
      if (4 & t && 'object' == typeof e && e && e.__esModule) return e
      var a = Object.create(null)
      if (
        (i.r(a),
        Object.defineProperty(a, 'default', { enumerable: !0, value: e }),
        2 & t && 'string' != typeof e)
      )
        for (var n in e)
          i.d(
            a,
            n,
            function (t) {
              return e[t]
            }.bind(null, n)
          )
      return a
    }),
    (i.n = function (e) {
      var t =
        e && e.__esModule
          ? function () {
              return e.default
            }
          : function () {
              return e
            }
      return i.d(t, 'a', t), t
    }),
    (i.o = function (e, t) {
      return Object.prototype.hasOwnProperty.call(e, t)
    }),
    (i.p = '')
  var l = (window.webpackJsonp = window.webpackJsonp || []),
    s = l.push.bind(l)
  ;(l.push = t), (l = l.slice())
  for (var u = 0; u < l.length; u++) t(l[u])
  var d = s
  o.push([46, 0]), a()
})([
  ,
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var n,
      r = a(0),
      o = (n = r) && n.__esModule ? n : { default: n }
    class i extends o.default.Component {
      render() {
        return o.default.createElement(
          'a',
          { href: this.props.url },
          o.default.createElement('img', {
            className: 'socialMenuItem',
            src: this.props.image
          })
        )
      }
    }
    t.default = i
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var n = l(a(0)),
      r = l(a(6)),
      o = l(a(8)),
      i = l(a(10))
    function l(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class s extends n.default.Component {
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
            n.default.createElement(o.default, {
              username: this.props.twitter.username
            })
          ),
          n.default.createElement(
            'li',
            null,
            n.default.createElement(i.default, {
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
    var n = o(a(0)),
      r = o(a(4))
    o(a(14))
    function o(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class i extends n.default.Component {
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
    t.default = i
  },
  function (e, t, a) {
    e.exports = a.p + '../83bac1b50602cac313ef8ceb4868ad3e.png'
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var n = o(a(0)),
      r = o(a(2))
    function o(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class i extends n.default.Component {
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
    t.default = i
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var n = i(a(0)),
      r = i(a(7)),
      o = i(a(1))
    function i(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class l extends n.default.Component {
      render() {
        var e = 'https://facebook.com/' + this.props.username
        return n.default.createElement(o.default, { url: e, image: r.default })
      }
    }
    t.default = l
  },
  function (e, t, a) {
    e.exports = a.p + '../46b6ac49f3ed295918c8fae5050f9276.png'
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var n = i(a(0)),
      r = i(a(9)),
      o = i(a(1))
    function i(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class l extends n.default.Component {
      render() {
        var e = 'https://twitter.com/' + this.props.username
        return n.default.createElement(o.default, { url: e, image: r.default })
      }
    }
    t.default = l
  },
  function (e, t, a) {
    e.exports = a.p + '../664a1f44ed01e235d4bf54d3e5bfe887.png'
  },
  function (e, t, a) {
    'use strict'
    Object.defineProperty(t, '__esModule', { value: !0 })
    var n = l(a(0)),
      r = l(a(11)),
      o = l(a(12)),
      i = l(a(1))
    function l(e) {
      return e && e.__esModule ? e : { default: e }
    }
    class s extends n.default.Component {
      render() {
        var e = 'https://github.com/' + this.props.username,
          t = r.default
        return (
          'true' === this.props.dark && (t = o.default),
          n.default.createElement(i.default, { url: e, image: t })
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
      var e, t, a, n, r, o
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
        (o = t.getElementsByTagName(a)[0]),
        (r.async = 1),
        (r.src = 'https://www.google-analytics.com/analytics.js'),
        o.parentNode.insertBefore(r, o),
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
      r = a(47),
      o = a(15),
      i = a(13)
    ;((n = i) && n.__esModule ? n : { default: n }).default.analytics()
    var l = document.getElementById('root')
    null !== l && (0, o.render)((0, r.renderRoot)(), l)
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
            n.default.createElement('h1', null, 'Terms of Use'),
            n.default.createElement(
              'ol',
              null,
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Acceptance of Terms.')
              ),
              n.default.createElement(
                'p',
                null,
                'Welcome to the HartCode Website. By using this Website you agree to be bound by these “Terms of Use.” If you do not agree to the terms and conditions of this Terms of Use, please stop using the HartCode Website. This Terms of Use may change at HartCode’s sole discretion, without notice. Therefore, we suggest that you check this page often to stay aware of the Terms of Use.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Definitions.')
              ),
              n.default.createElement(
                'p',
                null,
                'The “HartCode Website” or “the Website” means the website associated with the domain name hartcode.com. “HartCode” refers to HartCode LLC, the owner of the Website.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Use of the Site.')
              ),
              n.default.createElement(
                'p',
                null,
                'HartCode operates the Website to provide online access to information about HartCode and its products, services, and opportunities, as well as to sell certain products and licenses and to provide online access to certain games such as through accounts. Any new features added to the Website will also be subject to these Terms of Use. If your use of the Services, Game, Website or disclosure of information as described herein would violate any law, your right to use the Service, Game, Website and/or disclosure of such information is withdrawn.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Use of the Games.')
              ),
              n.default.createElement(
                'p',
                null,
                'Use of any version of any game offered by HartCode (“Game”) and other materials associated therewith, e.g. Games may be available for download (“Applications”), is restricted to those users logged into an Account over which they own or have permission to use and is governed by the End User License Agreement at ',
                n.default.createElement(
                  'a',
                  { href: '/end-user-license-agreement' },
                  'https://hartcode.com/end-user-license-agreement'
                ),
                ', which is incorporated herein.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Content & User Content.')
              ),
              n.default.createElement(
                'p',
                null,
                'The content on the Website, including without limitation, the trademarks, copyrights, text, software, graphics, photos, music, videos, and the like (“Content”), is owned by or licensed to HartCode and is subject to trademark, copyright and other intellectual property laws of the United States and foreign countries. Content on the Website is provided for your personal use only and may not be used, copied, reproduced, distributed, transmitted, broadcast, displayed, sold, licensed, or otherwise exploited for any other purposes whatsoever without the prior written consent of HartCode. HartCode reserves all rights not expressly granted in and to the Website and the Content.'
              ),
              n.default.createElement(
                'p',
                null,
                'You may be able to post user-generated content, such as comments, photos, presentations, articles, profiles (including your name, image, and likeness), messages, notes, text, information, music, and videos (“User Content”) on the Website. You will remain the owner of the User Content. By posting User Content, you grant HartCode an irrevocable, perpetual, non-exclusive, transferable, sub-licensable, fully paid, worldwide license (with the right to sublicense) to use, copy, publicly perform, publicly display, reformat, edit, translate, excerpt (in whole or in part) and distribute such User Content for any purpose, commercial, advertising, or otherwise, on or in connection with HartCode, the Website or the promotion thereof, to prepare derivative works of, or incorporate into other works, such User Content, and to grant and authorize sublicenses of the foregoing. For example and without limiting the foregoing, by posting comments to any portion of the Website, you grant HartCode the right to use, copy, edit, highlight, feature, distribute, and display those comments or any portion thereof in the Website and in promotions thereof in any manner and for any purpose. By posting User Content, you represent and warrant that (i) you have the right to post the User Content, (ii) that no third party rights, laws or regulations, e.g. COPPA and FERPA, will be violated by such posting, (iii) that you have the right to grant HartCode the rights granted herein, (iv) that no User Content contains any personal information regarding anyone under the age of 18, (v) the User Content is not harmful, fraudulent, threatening, abusive, harassing, defamatory, vulgar, obscene, libelous, or otherwise objectionable or offensive, and (vi) the User Content does not make the security of the Website vulnerable in any way. You acknowledge that HartCode and its designees shall have the right (but not the obligation) in their sole discretion to refuse or remove any User Content or material that is available through the Website. You also hereby grant each user a non-exclusive, fully paid, worldwide license to use, copy, publicly perform, publicly display, reformat, edit, translate, excerpt (in whole or in part) any User Content submitted by you during use of the Website.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Privacy Policy.')
              ),
              n.default.createElement(
                'p',
                null,
                'Our Privacy Policy governs the collection, use and disclosure of all Personal Data (personally identifiable information about you, such as your full name, birth date, e-mail address or mailing address, phone number and any other information that can be used to identify or contact you) and is incorporated herein. For more information, see our full Privacy Policy at ',
                n.default.createElement(
                  'a',
                  { href: '/privacy' },
                  'https://hartcode.com/privacy'
                ),
                '.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement(
                  'h3',
                  null,
                  'Third Party Intellectual Property.'
                )
              ),
              n.default.createElement(
                'p',
                null,
                'HartCode respects the intellectual property rights of others. We will respond promptly to remove material that infringes another person’s copyright or other intellectual property right. When reporting infringing material to HartCode (“DMCA Notice”) please provide:'
              ),
              n.default.createElement(
                'ol',
                null,
                n.default.createElement(
                  'li',
                  null,
                  'A physical or electronic signature of a person authorized to act on behalf of the owner of an exclusive right that is allegedly infringed.'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'Identification of the copyrighted work claimed to have been infringed, or, if multiple copyrighted works at a single online site are covered by a single notification, a representative list of such works at that site.'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'Identification of the material that is claimed to be infringing or to be the subject of infringing activity and that is to be removed or access to which is to be disabled, and information reasonably sufficient to permit HartCode to locate the material.'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'Information reasonably sufficient to permit HartCode to contact the complaining party, such as an address, telephone number, and, if available, an electronic mail address at which the complaining party may be contacted.'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'A statement that the complaining party has a good faith belief that use of the material in the manner complained of is not authorized by the copyright owner, its agent, or the law.'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'A statement that the information in the notification is accurate, and under penalty of perjury, that the complaining party is authorized to act on behalf of the owner of an exclusive right that is allegedly infringed.'
                )
              ),
              n.default.createElement(
                'p',
                null,
                'Upon receiving a complete DMCA Notice, HartCode will'
              ),
              n.default.createElement(
                'ol',
                null,
                n.default.createElement(
                  'li',
                  null,
                  'take reasonable steps promptly to notify the user that HartCode has removed or disabled access to the allegedly infringing material;'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'upon receipt of a counter notification described below, promptly provide the person who provided the notification with a copy of the counter notification, and inform that person that HartCode will replace the removed material or cease disabling access to it in 10 business days; and'
                ),
                n.default.createElement(
                  'li',
                  null,
                  "replace the removed material and cease disabling access to it not less than 10, nor more than 14, business days following receipt of the counter notice, unless HartCode's designated agent (identified below) first receives notice from the person who submitted the notification that such person has filed an action seeking a court order to restrain the user from engaging in infringing activity relating to the material on the Website, Game or through the Service."
                )
              ),
              n.default.createElement(
                'p',
                null,
                'A counter notification must include:'
              ),
              n.default.createElement(
                'ol',
                null,
                n.default.createElement(
                  'li',
                  null,
                  'A physical or electronic signature of the user.'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'Identification of the material that has been removed or to which access has been disabled and the location at which the material appeared before it was removed or access to it was disabled.'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'A statement under penalty of perjury that the user has a good faith belief that the material was removed or disabled as a result of mistake or misidentification of the material to be removed or disabled.'
                ),
                n.default.createElement(
                  'li',
                  null,
                  'The user’s name, address, and telephone number, and a statement that the user consents to the jurisdiction of Federal District Court for the judicial district in which the address is located, or if the user’s address is outside of the United States, for any judicial district in which HartCode may be found, and that the user will accept service of process from the person who provided notification or an agent of such person.'
                )
              ),
              n.default.createElement(
                'p',
                null,
                'Pursuant to the Digital Millennium Copyright Act (17 U.S.C. §512(c)(2)), our designated agent to receive notices and counter notices of claimed infringement is:'
              ),
              n.default.createElement(
                'p',
                null,
                'DMCA Notice',
                n.default.createElement('br', null),
                'c/o Alex Hart',
                n.default.createElement('br', null),
                '9941 Flagstone Dr',
                n.default.createElement('br', null),
                'Cedarburg, WI 53012',
                n.default.createElement('br', null),
                'contact@hartcode.com'
              ),
              n.default.createElement(
                'p',
                null,
                'We reserve the right to remove any infringing material that we believe in good faith to be copyrighted material that is used without authorization by user of the Website. We also reserve the right to suspend or delete the account of any repeat offender.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Website Provided "As Is".')
              ),
              n.default.createElement(
                'p',
                null,
                'You understand and agree that the HartCode Website and all services and information provided on it are provided “As Is” and that HartCode assumes no responsibility for the accuracy, timeliness, deletion or mis-delivery of any user communication, information, or configuration. You, and not HartCode, are entirely responsible for all material that you post, transmit or otherwise make available through the Website. HartCode does not review or control the material that others post, transmit or otherwise make available through the Website, and accordingly HartCode does not guarantee the accuracy, integrity or quality of such material. You acknowledge that HartCode and its designees shall have the right (but not the obligation) in their sole discretion to refuse or remove any material that is available through the Website.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Indemnification.')
              ),
              n.default.createElement(
                'p',
                null,
                'You agree to indemnify and hold harmless HartCode, and its subsidiaries, affiliates, officers, agents, and employees, from any claim or demand by any third party arising out of material you post, transmit or otherwise make available through the Website, your use of the Website, your connection to the Website, your violation of these Terms of Use, or your violation of any rights of another person or entity.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'DISCLAIMER.')
              ),
              n.default.createElement(
                'p',
                null,
                'THIS WEBSITE, INCLUDING ANY CONTENT OR INFORMATION CONTAINED WITHIN OR PROVIDED THROUGH IT, IS PROVIDED “AS IS” WITH NO REPRESENTATIONS OR WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, AND NON-INFRINGEMENT. YOU ASSUME TOTAL RESPONSIBILITY AND RISK FOR YOUR USE OF THIS WEBSITE AND THE INFORMATION RECEIVED THROUGH IT. FURTHER, HARTCODE MAKES NO REPRESENTATIONS WHATSOEVER ABOUT OTHER WEBSITES WHICH YOU MAY ACCESS THROUGH ITS WEBSITE or the content, SERVICES OR PRODUCTS contained therein or obtained there through. HARTCODE FURTHER DOES NOT WARRANT THE QUALITY, VALIDITY, ACCURACY OR COMPLETENESS OF THE MATERIALS OR THAT THE FUNCTIONS CONTAINED ON THE WEBSITE WILL BE UNINTERRUPTED OR ERROR-FREE, OR THAT DEFECTS OR INACCURACIES WILL BE CORRECTED. HARTCODE MAY MAKE CHANGES TO THE WEBSITE, OR TO THE PRODUCTS, SERVICES, SPECIFICATIONS OR PRICES DESCRIBED IN IT, AT ANY TIME WITHOUT NOTICE. THE MATERIALS MAY BE OUT OF DATE, AND FILAMENT GAMES MAKES NO COMMITMENT TO UPDATE THE MATERIALS AT THIS WEBSITE OR TO MAKE ANY NOTIFICATION OF CHANGES. INFORMATION PUBLISHED AT THIS WEBSITE MAY REFER TO PRODUCTS, PROGRAMS OR SERVICES THAT ARE NOT AVAILABLE. YOU HEREBY RELEASE HartCode from any and all claims, demands and damages, known or unknown, suspected or unsuspected, disclosed or undisclosed, arising out of or in any way related to a dispute between you and another USER. California residents hereby shall and do waive California Civil Code 1542, which provides “A general release does not extend to claims which the creditor does not know or suspect to exist in his or her favor at the time of executing the release, which if known by him or her must have materially affected his or her settlement with the debtor.”'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'LIMITATION OF LIABILITY.')
              ),
              n.default.createElement(
                'p',
                null,
                'HARTCODE AND ITS MEMBERS, DIRECTORS, OFFICERS, EMPLOYEES AND AGENTS AND ITS AFFILIATES ARE NEITHER RESPONSIBLE NOR LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, CONSEQUENTIAL, SPECIAL, EXEMPLARY, PUNITIVE OR OTHER DAMAGES ARISING OUT OF OR RELATING IN ANY WAY TO THE WEBSITE OR ANY INFORMATION RECEIVED FROM THE WEBSITE, INCLUDING THE CONTENT OR ANY INFORMATION CONTAINED WITHIN OR THROUGH THE WEBSITE. YOUR SOLE REMEDY FOR DISSATISFACTION WITH THE WEBSITE IS TO STOP USING THE WEBSITE AND THE INFORMATION OBTAINED THEREIN.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Patches and Updates.')
              ),
              n.default.createElement(
                'p',
                null,
                'HartCode may apply patches, updates and modifications to its Website at any time (each an “Update”). HartCode may change, modify, suspend, or discontinue any aspect of any Website at any time. HartCode may also impose limits on certain features or restrict your access to parts or all of the Website without notice or liability. HartCode makes no representation that the Website will work on a particular web browser, version of a web browser or device. You are responsible for having necessary Internet connections, equipment, software (including a web browser) and services for you to effectively access the Website. HartCode will endeavor to make the Website accessible on the most common web browsers and the current and penultimate version of such web browsers and some common devices, but make no representations or warranties on the same.'
              ),
              n.default.createElement(
                'li',
                null,
                n.default.createElement('h3', null, 'Miscellaneous.')
              ),
              n.default.createElement(
                'p',
                null,
                "These Terms of Use and the relationship between you and HartCode shall be governed by the laws of the State of Wisconsin. You hereby consent to the exclusive jurisdiction and forum of the federal and state courts located in the State of Wisconsin for all purposes in connection with any action or proceeding which arises out of or relates to your use of the Website, these Terms of Use, or any Content or Registration Data. HartCode's failure to enforce any right or provision of these Terms of Use does not constitute a waiver of that right or provision. HartCode may revise these Terms of Use at any time, and any such revisions shall be effective immediately without notice. You should visit this page from time to time to review the then-current Terms of Use. HartCode may, in its sole discretion, terminate or suspend your access to all or part of the Website for any reason, including, without limitation, breach of these Terms of Use."
              )
            )
          ),
          n.default.createElement(o.default, null)
        )
      })
    var n = i(a(0)),
      r = i(a(3)),
      o = i(a(5))
    function i(e) {
      return e && e.__esModule ? e : { default: e }
    }
  }
])
