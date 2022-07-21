// Generated from C:/Users/lenovo/IdeaProjects/P11_43_1746_Samar/src\task8.g4 by ANTLR 4.10.1
package csen1002.main.task8;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class task8Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Q2=1, Q3=2, Q4=3;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Q0", "Q0E", "Q1", "Q2", "Q3", "Q4", "Q4E", "ZERO", "ONE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Q2", "Q3", "Q4"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public task8Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "task8.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0003\u0083\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000\u001a\b\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001*\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u00025\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003B\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004T\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005c\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006~\b\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0000\u0000\t\u0001\u0000\u0003\u0000\u0005\u0000\u0007\u0001\t\u0002"+
		"\u000b\u0003\r\u0000\u000f\u0000\u0011\u0000\u0001\u0000\u0000\u0089\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0001\u0019\u0001\u0000\u0000\u0000\u0003)\u0001"+
		"\u0000\u0000\u0000\u00054\u0001\u0000\u0000\u0000\u0007A\u0001\u0000\u0000"+
		"\u0000\tS\u0001\u0000\u0000\u0000\u000bb\u0001\u0000\u0000\u0000\r}\u0001"+
		"\u0000\u0000\u0000\u000f\u007f\u0001\u0000\u0000\u0000\u0011\u0081\u0001"+
		"\u0000\u0000\u0000\u0013\u0014\u0003\u000b\u0005\u0000\u0014\u0015\u0003"+
		"\u000f\u0007\u0000\u0015\u0016\u0003\u000f\u0007\u0000\u0016\u0017\u0003"+
		"\u0003\u0001\u0000\u0017\u001a\u0001\u0000\u0000\u0000\u0018\u001a\u0003"+
		"\u0003\u0001\u0000\u0019\u0013\u0001\u0000\u0000\u0000\u0019\u0018\u0001"+
		"\u0000\u0000\u0000\u001a\u0002\u0001\u0000\u0000\u0000\u001b*\u0001\u0000"+
		"\u0000\u0000\u001c\u001d\u0003\u0011\b\u0000\u001d\u001e\u0003\u0003\u0001"+
		"\u0000\u001e*\u0001\u0000\u0000\u0000\u001f \u0003\u000f\u0007\u0000 "+
		"!\u0003\u0011\b\u0000!\"\u0003\u0003\u0001\u0000\"*\u0001\u0000\u0000"+
		"\u0000#$\u0003\u000f\u0007\u0000$%\u0003\u000f\u0007\u0000%&\u0003\u000f"+
		"\u0007\u0000&\'\u0003\u000f\u0007\u0000\'(\u0003\u0003\u0001\u0000(*\u0001"+
		"\u0000\u0000\u0000)\u001b\u0001\u0000\u0000\u0000)\u001c\u0001\u0000\u0000"+
		"\u0000)\u001f\u0001\u0000\u0000\u0000)#\u0001\u0000\u0000\u0000*\u0004"+
		"\u0001\u0000\u0000\u0000+,\u0003\u000b\u0005\u0000,-\u0003\u000f\u0007"+
		"\u0000-.\u0003\u000f\u0007\u0000./\u0003\u0003\u0001\u0000/0\u0003\u000f"+
		"\u0007\u000005\u0001\u0000\u0000\u000012\u0003\u0003\u0001\u000023\u0003"+
		"\u000f\u0007\u000035\u0001\u0000\u0000\u00004+\u0001\u0000\u0000\u0000"+
		"41\u0001\u0000\u0000\u00005\u0006\u0001\u0000\u0000\u000067\u0003\u000b"+
		"\u0005\u000078\u0003\u000f\u0007\u000089\u0003\u000f\u0007\u00009:\u0003"+
		"\u0003\u0001\u0000:;\u0003\u000f\u0007\u0000;<\u0003\u000f\u0007\u0000"+
		"<B\u0001\u0000\u0000\u0000=>\u0003\u0003\u0001\u0000>?\u0003\u000f\u0007"+
		"\u0000?@\u0003\u000f\u0007\u0000@B\u0001\u0000\u0000\u0000A6\u0001\u0000"+
		"\u0000\u0000A=\u0001\u0000\u0000\u0000B\b\u0001\u0000\u0000\u0000CD\u0003"+
		"\u000b\u0005\u0000DE\u0003\u000f\u0007\u0000EF\u0003\u000f\u0007\u0000"+
		"FG\u0003\u0003\u0001\u0000GH\u0003\u000f\u0007\u0000HI\u0003\u000f\u0007"+
		"\u0000IJ\u0003\u000f\u0007\u0000JT\u0001\u0000\u0000\u0000KL\u0003\u0003"+
		"\u0001\u0000LM\u0003\u000f\u0007\u0000MN\u0003\u000f\u0007\u0000NO\u0003"+
		"\u000f\u0007\u0000OT\u0001\u0000\u0000\u0000PQ\u0003\u000b\u0005\u0000"+
		"QR\u0003\u000f\u0007\u0000RT\u0001\u0000\u0000\u0000SC\u0001\u0000\u0000"+
		"\u0000SK\u0001\u0000\u0000\u0000SP\u0001\u0000\u0000\u0000T\n\u0001\u0000"+
		"\u0000\u0000UV\u0003\u0003\u0001\u0000VW\u0003\u000f\u0007\u0000WX\u0003"+
		"\u000f\u0007\u0000XY\u0003\u0011\b\u0000YZ\u0003\r\u0006\u0000Zc\u0001"+
		"\u0000\u0000\u0000[\\\u0003\u0003\u0001\u0000\\]\u0003\u000f\u0007\u0000"+
		"]^\u0003\u000f\u0007\u0000^_\u0003\u000f\u0007\u0000_`\u0003\u0011\b\u0000"+
		"`a\u0003\r\u0006\u0000ac\u0001\u0000\u0000\u0000bU\u0001\u0000\u0000\u0000"+
		"b[\u0001\u0000\u0000\u0000c\f\u0001\u0000\u0000\u0000d~\u0001\u0000\u0000"+
		"\u0000ef\u0003\u000f\u0007\u0000fg\u0003\u000f\u0007\u0000gh\u0003\u0003"+
		"\u0001\u0000hi\u0003\u000f\u0007\u0000ij\u0003\u000f\u0007\u0000jk\u0003"+
		"\u0011\b\u0000kl\u0003\r\u0006\u0000l~\u0001\u0000\u0000\u0000mn\u0003"+
		"\u000f\u0007\u0000no\u0003\u000f\u0007\u0000op\u0003\u0003\u0001\u0000"+
		"pq\u0003\u000f\u0007\u0000qr\u0003\u000f\u0007\u0000rs\u0003\u000f\u0007"+
		"\u0000st\u0003\u0011\b\u0000tu\u0003\r\u0006\u0000u~\u0001\u0000\u0000"+
		"\u0000vw\u0003\u000f\u0007\u0000wx\u0003\u0011\b\u0000xy\u0003\r\u0006"+
		"\u0000y~\u0001\u0000\u0000\u0000z{\u0003\u0011\b\u0000{|\u0003\r\u0006"+
		"\u0000|~\u0001\u0000\u0000\u0000}d\u0001\u0000\u0000\u0000}e\u0001\u0000"+
		"\u0000\u0000}m\u0001\u0000\u0000\u0000}v\u0001\u0000\u0000\u0000}z\u0001"+
		"\u0000\u0000\u0000~\u000e\u0001\u0000\u0000\u0000\u007f\u0080\u00050\u0000"+
		"\u0000\u0080\u0010\u0001\u0000\u0000\u0000\u0081\u0082\u00051\u0000\u0000"+
		"\u0082\u0012\u0001\u0000\u0000\u0000\b\u0000\u0019)4ASb}\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}